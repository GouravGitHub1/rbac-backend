package com.rbac.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rbac.demo.dto.LoginDTO;
import com.rbac.demo.dto.UserDTO;
import com.rbac.demo.exception.CustomException;
import com.rbac.demo.model.Role;
import com.rbac.demo.model.User;
import com.rbac.demo.repository.RoleRepository;
import com.rbac.demo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	
	public User login(LoginDTO loginDTO) {
		List<User> users = userRepository.findByUsernameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());
		if (users.size()==0) {
			throw new CustomException("User Name or Password is wrong.");
		}
		return users.get(0);
	}
	
	public User getUserById(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new CustomException("User not found with id: " + userId));
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(UserDTO userDTO) {
		Long roleId = userDTO.getRoleId();
		
		Role role = roleRepository.findById(roleId)
		                           .orElseThrow(() -> new CustomException("Role not found with id: " + roleId));

		User user = new User();
		
		List<User> users = userRepository.findByUsername(userDTO.getUserName());
		if (users.size()!=0) {
			throw new CustomException("User already exist with given username.");
		}
		
		user.setUsername(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setBirthDate(userDTO.getDob());
		user.setRole(role); 
		
		return userRepository.save(user);
	}
	
	
	public User updateUser(UserDTO userDTO) {
	        
		Long roleId = userDTO.getRoleId();
		
		Role role = roleRepository.findById(roleId)
		                           .orElseThrow(() -> new CustomException("Role not found with id: " + roleId));
		
		User user = userRepository.findById(userDTO.getUserId())
	            .orElseThrow(() -> new CustomException("User not found with id: " + userDTO.getUserId()));

		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setBirthDate(userDTO.getDob());
		user.setRole(role); 
		
		return userRepository.save(user);
	}
	
	
	public void deleteUser(Long userId) {
		userRepository.findById(userId)
	            .orElseThrow(() -> new CustomException("User not found with id: " + userId));

		userRepository.deleteById(userId);
	}


}

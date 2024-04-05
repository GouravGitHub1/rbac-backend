package com.rbac.demo.service;

import java.util.List;

import com.rbac.demo.dto.LoginDTO;
import com.rbac.demo.dto.UserDTO;
import com.rbac.demo.model.User;

public interface UserService {
	
	public User createUser(UserDTO userDto);
	public User getUserById(Long userId);
	public List<User> getAllUsers();
	public User login(LoginDTO loginDTO);
	public User updateUser(UserDTO userDTO);
	public void deleteUser(Long userId);
}

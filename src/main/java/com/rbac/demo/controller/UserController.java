package com.rbac.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbac.demo.dto.LoginDTO;
import com.rbac.demo.dto.UserDTO;
import com.rbac.demo.model.User;
import com.rbac.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(consumes = "application/json", value = "/login")
	public ResponseEntity<User> login(@Valid @RequestBody LoginDTO loginDTO) {
		return ResponseEntity.ok(userService.login(loginDTO));
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	
	@PostMapping(consumes = "application/json", value = "/createUser")
	public ResponseEntity<User> creatUser(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.createUser(userDTO));
	}
	
	@PutMapping(consumes = "application/json", value = "/updateUser")
	public ResponseEntity<User> updateUser(@Valid @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.updateUser(userDTO));
	}
	
	@DeleteMapping(("delete/{userId}"))
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok("User deleted successfully with ID:" + userId);
	}
	
}

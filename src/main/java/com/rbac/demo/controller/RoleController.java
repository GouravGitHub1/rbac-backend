package com.rbac.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbac.demo.dto.RoleDTO;
import com.rbac.demo.model.Permission;
import com.rbac.demo.model.Role;
import com.rbac.demo.service.RoleService;
import com.rbac.demo.service.UserService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
	
	@Autowired
	RoleService roleServiceImpl;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<Role> getUserRole(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUserById(userId).getRole());
	}
	
	
	@GetMapping("/allRolesWithPermission")
	public ResponseEntity<List<RoleDTO>> getAllRolesWithPermission() {
		return ResponseEntity.ok(roleServiceImpl.getAllRolesWithPermissions());
	}
	
	@GetMapping("/allRoles")
	public ResponseEntity<List<Role>> getAllRoles() {
		return ResponseEntity.ok(roleServiceImpl.getAllRoles());
	}
	
	@GetMapping("/permissions")
	public ResponseEntity<List<Permission>> getAllPermissions(){
		return ResponseEntity.ok(roleServiceImpl.getAllPermissions());
	}
	
}

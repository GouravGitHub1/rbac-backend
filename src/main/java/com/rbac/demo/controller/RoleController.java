package com.rbac.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbac.demo.dto.RoleDTO;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
	
	@GetMapping("role/{userId}")
	public RoleDTO getUserRole(@PathVariable String userId) {
		return new RoleDTO();
	}
	
	
	@GetMapping("roles")
	public List<RoleDTO> getAllRoles() {
		List<RoleDTO> roles = new ArrayList<>();
		return roles;
	}
	
	
}

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
import com.rbac.demo.model.AppConfig;
import com.rbac.demo.model.User;
import com.rbac.demo.service.AppConfigService;
import com.rbac.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/config")
public class AppConfigController {
	
	@Autowired
	AppConfigService appConfigService;
	
	@GetMapping("/")
	public ResponseEntity<List<AppConfig>> fetchAppConfig(){
		return ResponseEntity.ok(appConfigService.fetchAppConfig());
	}
	
	@GetMapping("/toggleReadOnlyFlag")
	public ResponseEntity<String> toggleReadOnlyFlag(){
		appConfigService.toggleReadOnlyFlag();
		return ResponseEntity.ok("Flag Updated.");
	}
	
	@GetMapping("/fetchReadOnlyFlag")
	public ResponseEntity<String> fetchReadOnlyFlag(){
		return ResponseEntity.ok(appConfigService.fetchReadOnlyFlag());
	}
	
	
	
}

package com.rbac.demo.dto;

import java.util.List;

public class RoleDTO {
	
	String role;
	List<String> permissions;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	
	

}

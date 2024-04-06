package com.rbac.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.rbac.demo.model.Permission;
import com.rbac.demo.model.Role;

public class RoleDTO {
	
	Role role;
	List<Permission> permissions = new ArrayList<>();
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
}

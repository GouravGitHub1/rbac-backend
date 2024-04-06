package com.rbac.demo.service;

import java.util.List;

import com.rbac.demo.dto.RoleDTO;
import com.rbac.demo.model.Permission;
import com.rbac.demo.model.Role;
import com.rbac.demo.model.RolePermission;

public interface RoleService {
	
	
	public List<Role> getAllRoles();
	
	public List<Permission> getAllPermissions();
	
	public List<RolePermission> getAllPermissionsRoles();
	
	public List<RoleDTO> getAllRolesWithPermissions();
	
}

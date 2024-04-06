package com.rbac.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rbac.demo.dto.RoleDTO;
import com.rbac.demo.model.Permission;
import com.rbac.demo.model.Role;
import com.rbac.demo.model.RolePermission;
import com.rbac.demo.repository.PermissionRepository;
import com.rbac.demo.repository.RolePermissionRepository;
import com.rbac.demo.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	RolePermissionRepository rolePermissionRepository;
	
	
	public List<Role> getAllRoles(){
		List<Role> roles =  roleRepository.findAll();
		return roles;
	}
	
	public List<Permission> getAllPermissions(){
		List<Permission> permissions = permissionRepository.findAll();
		return permissions;
	}
	
	public List<RolePermission> getAllPermissionsRoles(){
		List<RolePermission> permissions = rolePermissionRepository.findAll();
		return permissions;
	}
	
	public List<RoleDTO> getAllRolesWithPermissions() {
        List<Object[]> results = roleRepository.findAllRolesWithPermissions();
        return mapResultsToRoles(results);
    }
	

    private List<RoleDTO> mapResultsToRoles(List<Object[]> results) {
        Map<Long, RoleDTO> roleMap = new HashMap<>();

        for (Object[] result : results) {
            Integer roleIdInt = (Integer) result[0]; // Assuming the first column in the result is role_id
            Long roleId = roleIdInt.longValue();
            RoleDTO role = roleMap.computeIfAbsent(roleId, id -> {
            	RoleDTO roleDto = new RoleDTO();
                Role newRole = new Role();
                newRole.setRoleId(roleId);
                newRole.setRoleName((String) result[1]); // Assuming the second column in the result is role_name
                newRole.setDescription((String) result[2]); // Assuming the third column in the result is description
                roleDto.setRole(newRole);
                roleDto.setPermissions(new ArrayList<>());
                return roleDto;
            });

            Permission permission = new Permission();
            Integer permidint = (Integer) result[3]; // Assuming the first column in the result is role_id
            permission.setPermissionId(permidint.longValue()); // Assuming the fourth column in the result is permission_id
            permission.setPermissionName((String) result[4]); // Assuming the fifth column in the result is permission_name
            permission.setDescription((String) result[5]); // Assuming the sixth column in the result is description
            
            role.getPermissions().add(permission);
        }

        return new ArrayList<>(roleMap.values());
    }

//    private List<RoleDTO> mapResultsToRoles(List<Object[]> results) {
//        return results.stream()
//                      .map(this::mapResultToRole)
//                      .collect(Collectors.toList());
//    }
//
//    private RoleDTO mapResultToRole(Object[] result) {
//        Role role = (Role) result[0];
//        Permission permission = (Permission) result[1];
//        RoleDTO roleDto = new RoleDTO();
//        roleDto.setRole(role);
//        roleDto.getPermissions().add(permission);
//        return roleDto;
//    }
//    
}


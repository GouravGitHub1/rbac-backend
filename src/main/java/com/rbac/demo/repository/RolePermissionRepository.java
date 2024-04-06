package com.rbac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbac.demo.model.Permission;
import com.rbac.demo.model.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long>{

}

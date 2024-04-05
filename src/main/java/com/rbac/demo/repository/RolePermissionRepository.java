package com.rbac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbac.demo.model.Permission;

public interface RolePermissionRepository extends JpaRepository<Permission, Long>{

}

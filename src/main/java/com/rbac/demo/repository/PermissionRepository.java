package com.rbac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbac.demo.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}

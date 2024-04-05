package com.rbac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbac.demo.model.User;

public interface PermissionRepository extends JpaRepository<User, Long>{

}

package com.rbac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbac.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}

package com.rbac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rbac.demo.model.Role;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value = "SELECT r.*, p.* FROM roles r JOIN role_permissions rp ON r.role_id = rp.role_id JOIN permissions p ON rp.permission_id = p.permission_id", nativeQuery = true)
    List<Object[]> findAllRolesWithPermissions();
    
}

package com.rbac.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbac.demo.model.User;

public interface UserRepository extends JpaRepository<User	, Long>{
	
	List<User> findByUsernameAndPassword(String userName, String password);
	List<User> findByUsername(String userName);
	

}

package com.rbac.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbac.demo.model.AppConfig;

public interface AppConfigRepository extends JpaRepository<AppConfig, Long>{
	
	public AppConfig findByConfigKey(String key);
	
}

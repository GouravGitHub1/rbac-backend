package com.rbac.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_config")
public class AppConfig {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String configKey;
    private String configValue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

    
}

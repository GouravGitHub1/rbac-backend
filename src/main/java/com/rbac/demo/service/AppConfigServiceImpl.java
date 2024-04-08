package com.rbac.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.rbac.demo.model.AppConfig;
import com.rbac.demo.repository.AppConfigRepository;

@Service
@Transactional
public class AppConfigServiceImpl implements AppConfigService{
	
	@Autowired
	AppConfigRepository appConfigRepo;
	
	
	public List<AppConfig> fetchAppConfig() {
		return appConfigRepo.findAll();
		
	}
	
	public void toggleReadOnlyFlag() {
		AppConfig readOnlyFlagconfig = appConfigRepo.findByConfigKey("readOnlyFlag");
		if (readOnlyFlagconfig.getConfigValue().equalsIgnoreCase("true")) {
			readOnlyFlagconfig.setConfigValue("false");
		}
		else {
			readOnlyFlagconfig.setConfigValue("true");
		}
		appConfigRepo.save(readOnlyFlagconfig);
	}
	

	public String fetchReadOnlyFlag() {
		return appConfigRepo.findByConfigKey("readOnlyFlag").getConfigValue();
	}
	
}

package com.rbac.demo.service;

import java.util.*;
import com.rbac.demo.model.AppConfig;

public interface AppConfigService {
	public List<AppConfig> fetchAppConfig();
	public void toggleReadOnlyFlag();
	public String fetchReadOnlyFlag();
}

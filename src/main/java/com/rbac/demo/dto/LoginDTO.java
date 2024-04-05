package com.rbac.demo.dto;

import jakarta.validation.constraints.NotNull;

public class LoginDTO {
	
	@NotNull(message="User ID should be present, please check")
	String userName;
	@NotNull(message="User ID should be present, please check")
	String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

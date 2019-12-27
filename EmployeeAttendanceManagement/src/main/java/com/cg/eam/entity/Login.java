package com.cg.eam.entity;

import javax.persistence.Entity;


public class Login {

	private String userName;
	//private String name;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

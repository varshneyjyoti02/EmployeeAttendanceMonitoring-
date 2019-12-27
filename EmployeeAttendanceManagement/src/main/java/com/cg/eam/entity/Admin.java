package com.cg.eam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue
	private int adminNumber;
	private String userName;
	private String password;

	public int getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

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

	@Override
	public String toString() {
		return "Admin [adminNumber=" + adminNumber + ", userName=" + userName + ", password=" + password + "]";
	}

}

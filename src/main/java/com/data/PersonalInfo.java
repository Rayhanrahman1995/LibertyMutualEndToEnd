package com.data;

public class PersonalInfo {

	private String username;
	private String password;

	public PersonalInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public String getPassWord() {
		return password;
	}
}

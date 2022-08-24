package com.cognixia.jump.model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userID;
	private String username;
	private String password;
	private String email;

	public User() {
		this.userID = 0;
		this.username = "";
		this.password = "";
		this.email="";
	}

	public User(int userID, String username, String password, String email) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + "]\n";
	}

}

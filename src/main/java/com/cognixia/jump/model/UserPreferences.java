package com.cognixia.jump.model;

import java.io.Serializable;

public class UserPreferences implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userID;
	private String genre;
	
	public UserPreferences(int userID, String genre) {
		super();
		this.userID = userID;
		this.genre = genre;
	}

	public int getUserID() {
		return userID;
	}

	public String getGenre() {
		return genre;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "UserPreferences [userID=" + userID + ", genre=" + genre + "]";
	}
}

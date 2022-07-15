package com.cognixia.jump.model;

import java.io.Serializable;

public class Tracker implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userID;
	private int bookID;
	private String progressStatus;

	public Tracker() {
		this(0, 0, "Not Started");
	}

	public Tracker(int userID, int bookID, String progressStatus) {
		this.userID = userID;
		this.bookID = bookID;
		this.progressStatus = progressStatus;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getProgressStatus() {
		return progressStatus;
	}

	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}

	@Override
	public String toString() {
		return "Tracker [userID=" + userID + ", bookID=" + bookID + ", progressStatus=" + progressStatus + "]";
	}

}

package com.cognixia.jump.model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int bookID;
	private String name;
	private String author;
	private int pages;
	private String genre;
	private double criticRating;
	private double userRating;
	private int ratingCount;

	public Book() {

	}
	
	public Book(int bookID, String name, int pages, String author, String genre, double criticRating, double userRating, int ratingCount) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.author = author;
		this.pages = pages;
		this.genre = genre;
		this.criticRating = criticRating;
		this.userRating = userRating;
		this.ratingCount = ratingCount;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int id) {
		this.bookID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}

	public double getCriticRating() {
		return criticRating;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setCriticRating(double criticRating) {
		this.criticRating = criticRating;
	}

	public double getUserRating() {
		return userRating;
	}

	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	@Override
	public String toString() {
		return String.format("%66s | %30s | Critic Rating: %.2f / 5 | User Rating: %.2f / 5 | %2d ratings | Genre: %30s ",  name, author, criticRating, userRating, ratingCount, genre);
//		return "[bookID=" + bookID + ",\t\t name=" + name + ",\t\t pages=" + pages + ",\t\t author=" + author + ",\t\t rating=" + rating + ",\t\t genre=" + genre + "]";
	}
}

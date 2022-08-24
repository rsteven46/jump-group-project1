package com.cognixia.jump.model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int bookID;
	private String name;
	private String author;
	private int pages;
	private String genre;
	private double rating;

	public Book() {

	}
	
	public Book(int bookID, String name, int pages, String author, String genre, double rating) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.author = author;
		this.pages = pages;
		this.genre = genre;
		this.rating = rating;
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

	public double getRating() {
		return rating;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return String.format("%40s | %30s | rating %.2f | %30s",  name, author, rating, genre);
//		return "[bookID=" + bookID + ",\t\t name=" + name + ",\t\t pages=" + pages + ",\t\t author=" + author + ",\t\t rating=" + rating + ",\t\t genre=" + genre + "]";
	}
}

package com.cognixia.jump.model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int bookID;
	private String name;
	private int pages;
	private String author;

	public Book() {

	}
	
	public Book(int bookID, String name, int pages) {
		super();
		this.bookID = bookID;
		this.name = name;
		this.pages = pages;
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

	@Override
	public String toString() {
		return String.format("%6d | %60s | %6d | %30s | ", bookID, name, pages, author);
//		return "[bookID=" + bookID + ",\t\t name=" + name + ",\t\t pages=" + pages + ",\t\t author=" + author + "]";
	}
}

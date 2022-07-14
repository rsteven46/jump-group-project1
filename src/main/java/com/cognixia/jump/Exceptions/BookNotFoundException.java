package com.cognixia.jump.Exceptions;

public class BookNotFoundException extends Exception {
	
	public BookNotFoundException() {
		super("Book not found, please check your spelling. If spelling is correct book may not be in your list? I don't know man.");
	}

}

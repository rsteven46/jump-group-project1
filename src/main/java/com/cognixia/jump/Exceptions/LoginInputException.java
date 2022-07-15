package com.cognixia.jump.Exceptions;

public class  LoginInputException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginInputException(int id) {
		System.out.println("Record not found. Please check username/ password and try again");
	}

}

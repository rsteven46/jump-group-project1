package com.cognixia.jump.model;

import java.io.Serializable;

public class Genre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	public Genre(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Genre [name=" + name + "]";
	}

}

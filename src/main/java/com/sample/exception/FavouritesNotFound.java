package com.sample.exception;

public class FavouritesNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FavouritesNotFound(String message) {
		super(message);
	}

}

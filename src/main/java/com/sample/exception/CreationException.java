package com.sample.exception;

public class CreationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public CreationException(String message) {
		super(message);
	}
}

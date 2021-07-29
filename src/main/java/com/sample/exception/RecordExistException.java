package com.sample.exception;

public class RecordExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public RecordExistException(String message) {
		super(message);
	}
}

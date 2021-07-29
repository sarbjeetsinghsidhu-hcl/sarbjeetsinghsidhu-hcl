package com.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerInterceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(FavouritesNotFound.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(FavouritesNotFound exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CreationException.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(CreationException exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordExistException.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(RecordExistException exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
}

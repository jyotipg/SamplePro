package com.learn.exceptions;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ServletException.class)
	public ResponseEntity<APIResponse> handleContentEdCustomException(ServletException exception) {

		return new ResponseEntity<>(APIResponseMessage.builder().message(exception.getLocalizedMessage())
				.statusCode(HttpStatus.BAD_REQUEST.value()).build(), null, HttpStatus.BAD_REQUEST);
 
	}
	 
}


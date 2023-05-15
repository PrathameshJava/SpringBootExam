package com.java.main.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourseNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetail detail = new ErrorDetail(request.getDescription(false), ex.getMessage(), new Date());
		return new ResponseEntity<>(detail, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

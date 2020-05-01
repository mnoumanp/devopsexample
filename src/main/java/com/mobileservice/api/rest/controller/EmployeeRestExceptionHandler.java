package com.mobileservice.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mobileservice.api.exception.EmployeeNotFoundException;
import com.mobileservice.api.exception.UnauthorizedException;
import com.mobileservice.api.exception.UniqueUserException;
import com.mobileservice.api.util.ApplicationConstants;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	// Add an exception handler using @ExceptionHandler

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {

		// create CustomerNotFoundException
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ApplicationConstants.EMPLOYEE_NOT_FOUND_ERR);
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(UniqueUserException exc) {

		// create CustomerNotFoundException
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(ApplicationConstants.UNIQUE_USERNAME_ERR);
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(UnauthorizedException exc) {

		// create CustomerNotFoundException
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.UNAUTHORIZED);

	}

	// Add another exception handler to catch any exception

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {

		// create CustomerNotFoundException
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}

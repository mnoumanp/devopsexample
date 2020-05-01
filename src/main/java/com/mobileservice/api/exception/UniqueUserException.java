package com.mobileservice.api.exception;

public class UniqueUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UniqueUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UniqueUserException(String message) {
		super(message);
	}

	public UniqueUserException(Throwable cause) {
		super(cause);
	}

	public UniqueUserException() {
		super();
	}

}

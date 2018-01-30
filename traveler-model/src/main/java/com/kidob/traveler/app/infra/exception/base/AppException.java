package com.kidob.traveler.app.infra.exception.base;

/**
 * Base class for all application-specific exceptions
 * 
 * @author Bogdan
 *
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}
}

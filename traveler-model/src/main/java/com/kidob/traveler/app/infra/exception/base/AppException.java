package com.kidob.traveler.app.infra.exception.base;

/**
 * Base class for all application-specific exceptions
 * 
 * @author Bogdan
 *
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = -6281979120026716295L;

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable throwable) {
		super(throwable);
	}
}

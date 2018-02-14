package com.kidob.traveler.app.infra.exception;

import com.kidob.traveler.app.infra.exception.base.AppException;

/**
 * Signals about data access layer unexpected situations
 * 
 * @author Bogdan
 *
 */
public class PersistenceException extends AppException {

	private static final long serialVersionUID = -6258753165154980207L;

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenceException(String message) {
		super(message);
	}

}

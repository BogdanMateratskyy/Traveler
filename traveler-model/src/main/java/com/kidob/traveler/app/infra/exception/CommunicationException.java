package com.kidob.traveler.app.infra.exception;

import com.kidob.traveler.app.infra.exception.base.AppException;

/**
 * Signals about exception cases in the work of external services and API
 * 
 * @author Bogdan
 *
 */
public class CommunicationException extends AppException {

	private static final long serialVersionUID = 6620060563986777352L;

	public CommunicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommunicationException(String message) {
		super(message);
	}

}

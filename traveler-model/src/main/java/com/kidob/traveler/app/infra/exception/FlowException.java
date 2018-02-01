package com.kidob.traveler.app.infra.exception;

import com.kidob.traveler.app.infra.exception.base.AppException;

/**
 * Signals about exceptional cases in the application logic
 * 
 * @author Bogdan
 *
 */
public class FlowException extends AppException {

	private static final long serialVersionUID = 7608190877714995950L;

	public FlowException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlowException(String message) {
		super(message);
	}

}

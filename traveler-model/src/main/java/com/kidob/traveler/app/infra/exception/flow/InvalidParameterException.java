package com.kidob.traveler.app.infra.exception.flow;

import com.kidob.traveler.app.infra.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 * 
 * @author Bogdan
 *
 */
public class InvalidParameterException extends FlowException {

	private static final long serialVersionUID = 7524098948168574617L;

	public InvalidParameterException(String message) {
		super(message);
	}
}

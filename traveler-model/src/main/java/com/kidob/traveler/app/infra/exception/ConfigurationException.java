package com.kidob.traveler.app.infra.exception;

import com.kidob.traveler.app.infra.exception.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 * 
 * @author Bogdan
 *
 */
public class ConfigurationException extends AppException{
	
	private static final long serialVersionUID = -1947313354068455669L;

	public ConfigurationException(String message, Throwable cause) {
		super(message, cause);		
	}
	
	public ConfigurationException(String message) {
		super(message);		
	}
	
	public ConfigurationException(Throwable throwable) {
		super(throwable);		
	}

}

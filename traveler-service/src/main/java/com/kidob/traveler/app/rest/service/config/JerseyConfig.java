package com.kidob.traveler.app.rest.service.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")

/**
 * REST web-service configuration for Jersey
 * 
 * @author Bogdan
 *
 */
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		packages("com.kidob.traveler.app.rest");
	}
}

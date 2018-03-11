package com.kidob.traveler.app.rest.service.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.kidob.traveler.app.config.ComponentFeature;

@ApplicationPath("api")

/**
 * REST web-service configuration for Jersey
 * 
 * @author Bogdan
 *
 */
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		super(ComponentFeature.class);
		packages("com.kidob.traveler.app.rest");
	}
}

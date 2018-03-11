package com.kidob.traveler.app.config;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Registers DI bindings
 * 
 * @author Bogdan
 *
 */
public class ComponentFeature implements Feature{

	@Override
	public boolean configure(final FeatureContext context) {
		context.register(new ComponentBinder());
		return true;
	}

}

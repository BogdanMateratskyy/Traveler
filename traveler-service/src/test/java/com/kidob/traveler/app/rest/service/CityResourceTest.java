package com.kidob.traveler.app.rest.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import com.kidob.traveler.app.rest.service.CityResource;
import com.kidob.traveler.app.rest.service.config.JerseyConfig;

/**
 * {@link CityResourceTest} is integration test that verifies
 * {@link CityResource}
 * 
 * @author Bogdan
 *
 */
public class CityResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new JerseyConfig();
	}

	@Test
	public void testFindCitiesSuccess() {
		List<?> cities = target("cities").request().get(List.class);
		assertNotNull(cities);
		assertTrue(cities.contains("Oddesa"));
		assertTrue(cities.contains("Kyiv"));
	}
}

package com.kidob.traveler.app.rest.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.kidob.traveler.app.rest.dto.CityDTO;
//import com.kidob.traveler.app.rest.service.CityResource;
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
		List<Map<String, String>> cities = target("cities").request().get(List.class);
		assertNotNull(cities);
		assertEquals(cities.size(), 1);

		Map<String, String> city = cities.get(0);
		assertEquals(city.get("name"), "Odessa");
	}

	@Test
	public void testFindCityByIdSuccess() {
		CityDTO city = target("cities/1").request().get(CityDTO.class);
		assertNotNull(city);
		assertEquals(city.getId(), 1);
		assertEquals(city.getName(), "Odessa");
	}

	@Test
	public void testFindCityByIdNotFound() {
		Response response = target("cities/2").request().get(Response.class);
		assertNotNull(response);
		assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
	}

	@Test
	public void testFindCityByIdInvalidId() {
		Response response = target("cities/aaab").request().get(Response.class);
		assertNotNull(response);
		assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
	}

	@Test
	public void testSaveCitySuccess() {
		CityDTO city = new CityDTO();
		city.setName("Kyiv");
		city.setDistrict("Odessa");
		city.setRegion("Odessa");

		Response response = target("cities").request().post(Entity.entity(city, MediaType.APPLICATION_JSON));
		assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
	}
}

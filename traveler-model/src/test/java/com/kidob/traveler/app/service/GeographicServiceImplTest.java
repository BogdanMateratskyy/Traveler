package com.kidob.traveler.app.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kidob.traveler.app.model.entity.geography.City;
import com.kidob.traveler.app.service.impl.GeographicServiceImpl;

/**
 * Contains unit-tests for {@link GeographicServiceImpl}
 * 
 * @author Bogdan
 *
 */
public class GeographicServiceImplTest {

	private GeographicService service;

	@Before
	public void setup() {
		service = new GeographicServiceImpl();
	}

	@Test
	public void testNoDataReturnedAtStart() {
		List<City> cities = service.findCities();
		assertTrue(cities.isEmpty());
	}

	@Test
	public void testSaveNewCitySuccess() {
		City city = new City("Odessa");
		service.saveCity(city);

		List<City> cities = service.findCities();
		assertEquals(cities.size(), 1);
		assertEquals(cities.get(0).getName(), "Odessa");
	}
}

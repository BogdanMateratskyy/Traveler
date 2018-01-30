package com.kidob.traveler.app.model.entity.geography;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.kidob.traveler.app.model.entity.transport.TransportType;

/**
 * Contains unit-tests to check functionality of {@link City} class
 * 
 * @author Bogdan
 *
 */
public class CityTest {

	private City city;

	@Before
	public void setup() {
		city = new City("Odessa");
	}

	@Test
	public void testAddValidStationSuccess() {
		Station station = city.addStation(TransportType.AUTO);

		assertTrue(containsStation(city, station));
		assertEquals(city, station.getCity());
	}

	@Test(expected = NullPointerException.class)
	public void testAddStationNullTransportTypeFailure() {
		city.addStation(null);

		assertTrue(false);
	}

	@Test
	public void testRemoveStationSuccess() {
		Station station = city.addStation(TransportType.AVIA);

		city.removeStation(station);

		assertTrue(city.getStations().isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveNullStationFailure() {
		city.removeStation(null);

		assertTrue(false);
	}

	private boolean containsStation(City city2, Station station) {
		return city.getStations().contains(station);
	}
}

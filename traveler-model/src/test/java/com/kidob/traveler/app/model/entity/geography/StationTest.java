package com.kidob.traveler.app.model.entity.geography;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kidob.traveler.app.model.entity.transport.TransportType;
import com.kidob.traveler.app.model.search.criteria.StationCriteria;

/**
 * Verifies functionality of the {@link Station} domain entity
 * 
 * @author Bogdan
 *
 */
public class StationTest {

	@Test(expected = NullPointerException.class)
	public void testMatchCriteriaNotInitialized() {
		City city = new City("Odessa");
		Station station = new Station(city, TransportType.AUTO);

		station.match(null);
	}

	@Test
	public void testMatchByNameSuccess() {
		City city = new City("Odessa");
		Station station = new Station(city, TransportType.AUTO);

		assertTrue(station.match(StationCriteria.byName("Odessa")));
	}

	@Test
	public void testMatchByNameNotFound() {
		City city = new City("Odessa");
		Station station = new Station(city, TransportType.AUTO);

		assertFalse(station.match(StationCriteria.byName("Kyiv")));
	}
}

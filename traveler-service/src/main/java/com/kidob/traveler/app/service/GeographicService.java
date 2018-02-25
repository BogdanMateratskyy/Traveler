package com.kidob.traveler.app.service;

import java.util.List;
import java.util.Optional;

import com.kidob.traveler.app.model.entity.geography.City;
import com.kidob.traveler.app.model.entity.geography.Station;
import com.kidob.traveler.app.model.search.criteria.StationCriteria;
import com.kidob.traveler.app.model.search.criteria.range.RangeCriteria;

/**
 * Entry point to perform operations over geographic entities
 * 
 * @author Bogdan
 *
 */
public interface GeographicService {

	/**
	 * Return list of existing cities
	 * 
	 * @return
	 */
	List<City> findCities();

	/**
	 * Saves specified city instance
	 * 
	 * @param city
	 */
	void saveCity(City city);

	/**
	 * Returned city with specified identifier. If city isn't found then empty
	 * optional is returned.
	 * 
	 * @param id
	 * @return
	 */
	Optional<City> findCityById(int id);

	/**
	 * Returns all the stations that match specified criteria.
	 * 
	 * @param criteria
	 * @param rangeCriteria
	 * @return
	 */
	List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria);
}

package com.kidob.traveler.app.service;

import java.util.List;

import com.kidob.traveler.app.model.entity.geography.City;

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
}

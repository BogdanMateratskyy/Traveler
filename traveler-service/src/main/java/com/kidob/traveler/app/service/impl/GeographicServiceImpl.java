package com.kidob.traveler.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.kidob.traveler.app.infra.util.CommonUtil;
import com.kidob.traveler.app.model.entity.geography.City;
import com.kidob.traveler.app.service.GeographicService;

/**
 * Default implementation of the {@link GeographicService}
 * 
 * @author Bogdan
 *
 */
public class GeographicServiceImpl implements GeographicService {

	/**
	 * Internal list of cities
	 */
	private final List<City> cities;

	public GeographicServiceImpl() {
		cities = new ArrayList<City>();
	}

	@Override
	public List<City> findCities() {
		return CommonUtil.getSafeList(cities);
	}

	@Override
	public void saveCity(City city) {
		if (!cities.contains(city)) {
			cities.add(city);
		}
	}
}
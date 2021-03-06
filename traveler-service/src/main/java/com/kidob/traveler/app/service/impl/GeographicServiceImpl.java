package com.kidob.traveler.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.kidob.traveler.app.model.entity.geography.City;
import com.kidob.traveler.app.model.entity.geography.Station;
import com.kidob.traveler.app.model.search.criteria.StationCriteria;
import com.kidob.traveler.app.model.search.criteria.range.RangeCriteria;
import com.kidob.traveler.app.service.GeographicService;
import com.kidob.traveler.app.persistence.repository.CityRepository;
import com.kidob.traveler.app.persistence.repository.inmemory.InMemoryCityRepository;

/**
 * Default implementation of the {@link GeographicService}
 * 
 * @author Bogdan
 *
 */
public class GeographicServiceImpl implements GeographicService {
	private final CityRepository cityRepository;

	@Inject
	public GeographicServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<City> findCities() {
		return cityRepository.findAll();
	}

	@Override
	public void saveCity(City city) {
		cityRepository.save(city);
	}

	@Override
	public Optional<City> findCityById(final int id) {
		return Optional.ofNullable(cityRepository.findById(id));
	}

	@Override
	public List<Station> searchStations(
			final StationCriteria criteria, final RangeCriteria rangeCriteria) {
		Set<Station> stations = new HashSet<>();
		
		cityRepository.findAll().forEach(city -> stations.addAll(city.getStations()));
		
		return stations.stream()
				.filter(station -> station.match(criteria))
				.collect(Collectors.toList());
	}
}

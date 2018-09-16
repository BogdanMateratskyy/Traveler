package com.kidob.traveler.app.persistence.repository;

import java.util.List;

import com.kidob.traveler.app.model.entity.geography.Station;
import com.kidob.traveler.app.model.search.criteria.StationCriteria;

/**
 * Describes CRUD methods to access Station objects in the persistent storage
 * 
 * @author Bogdan
 *
 */
public interface StationRepository {

	/**
	 * Returns all the stations that match specified criteria
	 * 
	 * @param stationCriteria
	 * @return
	 */
	List<Station> findAllByCriteria(StationCriteria stationCriteria);
}

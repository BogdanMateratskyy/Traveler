package com.kidob.traveler.app.model.entity.geography;

import java.util.HashSet;
import java.util.Set;

import com.kidob.traveler.app.infra.util.CommonUtil;
import com.kidob.traveler.app.model.entity.base.AbstractEntity;
import com.kidob.traveler.app.model.entity.transport.TransportType;

/**
 * Any locality that contains transport stations
 * 
 * @author Bogdan
 *
 */
public class City extends AbstractEntity {

	private String name;
	/**
	 * Name of the district where city is placed
	 */
	private String district;
	/**
	 * Name of the region where district is located. Region is top-level area in
	 * the country
	 */
	private String region;
	/**
	 * Set of transport stations that is linked to this locality
	 */
	private Set<Station> stations;

	public City(final String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<Station> getStations() {
		return CommonUtil.getSafeSet(stations);
	}

	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}

	public Station addStation(final TransportType transportType) {
		if (stations == null) {
			stations = new HashSet<>();
		}
		Station station = new Station(this, transportType);
		stations.add(station);

		return station;
	}
}

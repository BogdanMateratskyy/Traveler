package com.kidob.traveler.app.config;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.kidob.traveler.app.persistence.hibernate.SessionFactoryBuilder;
import com.kidob.traveler.app.persistence.repository.CityRepository;
import com.kidob.traveler.app.persistence.repository.hibernate.HibernateCityRepository;
import com.kidob.traveler.app.service.GeographicService;
import com.kidob.traveler.app.service.impl.GeographicServiceImpl;
import com.kidob.traveler.app.service.transform.Transformer;
import com.kidob.traveler.app.service.transform.impl.SimpleDTOTransformer;

/**
 * Binds bean implementations and implemented interfaces
 * 
 * @author Bogdan
 * 
 */
public class ComponentBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(HibernateCityRepository.class).to(CityRepository.class).in(Singleton.class);
		bind(SimpleDTOTransformer.class).to(Transformer.class).in(Singleton.class);
		bind(GeographicServiceImpl.class).to(GeographicService.class).in(Singleton.class);
		bind(SessionFactoryBuilder.class).to(SessionFactoryBuilder.class).in(Singleton.class);
	}

}

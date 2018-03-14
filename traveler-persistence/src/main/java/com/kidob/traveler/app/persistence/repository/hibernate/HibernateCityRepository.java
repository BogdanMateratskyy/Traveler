package com.kidob.traveler.app.persistence.repository.hibernate;

import javax.inject.Inject;
import org.hibernate.SessionFactory;

import com.kidob.traveler.app.persistence.hibernate.SessionFactoryBuilder;

public class HibernateCityRepository {
	
	private final SessionFactory sessionFactory;

	@Inject
	public HibernateCityRepository(SessionFactoryBuilder builder) {
		sessionFactory = builder.getSessionFactory();
	}

}

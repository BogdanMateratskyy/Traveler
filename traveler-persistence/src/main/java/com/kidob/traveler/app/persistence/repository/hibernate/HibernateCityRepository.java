package com.kidob.traveler.app.persistence.repository.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidob.traveler.app.model.entity.geography.City;
import com.kidob.traveler.app.persistence.hibernate.SessionFactoryBuilder;
import com.kidob.traveler.app.persistence.repository.CityRepository;

public class HibernateCityRepository implements CityRepository {

	private final SessionFactory sessionFactory;

	@Inject
	public HibernateCityRepository(SessionFactoryBuilder builder) {
		sessionFactory = builder.getSessionFactory();
	}

	@Override
	public void save(City city) {
		try (Session session = sessionFactory.openSession()) {
			session.saveOrUpdate(city);
		}
	}

	@Override
	public City findById(int cityId) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(City.class, cityId);
		}
	}

	@Override
	public void delete(int cityId) {
		try (Session session = sessionFactory.openSession()) {
			City city = session.get(City.class, cityId);
			if (city != null) {
				session.delete(city);
			}
		}
	}

	@Override
	public List<City> findAll() {
		try (Session session = sessionFactory.openSession()) {
			// DEPRECATED as of Hibernate 5.2.0
			// return session.createCriteria(City.class).list();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<City> criteria = builder.createQuery(City.class);
			criteria.from(City.class);
			return session.createQuery(criteria).getResultList();
		}
	}

}

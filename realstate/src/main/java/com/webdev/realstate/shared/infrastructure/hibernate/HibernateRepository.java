package com.webdev.realstate.shared.infrastructure.hibernate;

import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

public class HibernateRepository<T> {

	protected final SessionFactory sessionFactory;
	protected final Class<T> aggregateClass;

	public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
		this.sessionFactory = sessionFactory;
		this.aggregateClass = aggregateClass;
	}

	protected void persist(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	protected Optional<List<T>> getAll() {
		CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);
		criteria.from(aggregateClass);
		return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
	}

	protected void updateEntity(T entity) {
		sessionFactory.getCurrentSession().update(entity);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	protected void deleteEntity(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}
}

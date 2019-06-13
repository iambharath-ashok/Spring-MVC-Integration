package com.guru.bharath.spring.hibernate.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T, ID extends Serializable> {

	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public T getEntityByKey(Class<?> clazz, ID id) {
		return (T) getSession().get(clazz, id);
	}

	public ID persist(T entity) {
		return (ID) getSession().save(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public T update(T entity) {
		return (T) getSession().merge(entity);
	}

	public Criteria createEntityCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}
}

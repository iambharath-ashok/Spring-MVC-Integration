package com.guru.bharath.springmvc.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao <T, ID extends Serializable>{

	@PersistenceContext(unitName="springMvc")
	protected EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public CriteriaQuery<T> createCriteriaQuery(Class<?> clazz) {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		return (CriteriaQuery<T>)criteriaBuilder.createQuery(clazz);
	}
	
	
	public Query getQuery(String query) {
		return getEntityManager().createQuery(query);
	}
	
}

package com.redhat.example.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.example.model.Person2;

@Dependent
public class PersonDao extends AbstractDao<Person2, String> {
	
	@PersistenceContext(unitName="ExamplePU")
	private EntityManager em;
	
	public PersonDao() {
		entityClass = Person2.class;
	}
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}

}

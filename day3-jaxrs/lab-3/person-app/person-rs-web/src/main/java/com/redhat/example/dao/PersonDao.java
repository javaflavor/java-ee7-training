package com.redhat.example.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.example.model.Person;

@Dependent
public class PersonDao extends AbstractDao<Person,Integer> {
	public PersonDao() {
		entityClass = Person.class;
	}
	
	@PersistenceContext(unitName="ExamplePU") EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}

}

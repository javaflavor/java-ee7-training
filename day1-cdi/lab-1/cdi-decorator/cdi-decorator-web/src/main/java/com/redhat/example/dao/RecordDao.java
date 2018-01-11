package com.redhat.example.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.redhat.example.model.Record;

@Dependent
public class RecordDao extends AbstractDao<Record,Integer> {

	@PersistenceContext(unitName="ExamplePU") EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}

}

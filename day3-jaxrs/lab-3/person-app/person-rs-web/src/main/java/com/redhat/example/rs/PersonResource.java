package com.redhat.example.rs;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.redhat.example.business.PersonFacade;
import com.redhat.example.ifs.BusinessException;
import com.redhat.example.ifs.PersonService;
import com.redhat.example.model.Person;

@Dependent
public class PersonResource implements PersonService {
	@Inject
	PersonFacade service;

	@Override
	public void create(Person entry) throws BusinessException {
		service.create(entry);
	}

	@Override
	public List<Person> findAll() {
		return service.findAll();
	}

	@Override
	public Person find(int id) {
		return service.find(id);
	}

	@Override
	public void update(Person entity) {
		service.update(entity);
	}

	@Override
	public void remove(int id) {
		service.remove(id);
	}

}

package com.redhat.example.business;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.example.ifs.BusinessException;
import com.redhat.example.ifs.PersonService;
import com.redhat.example.model.Person;

@Model
@Transactional
public class PersonFacade {
	
	@Inject PersonService service;
	
	public void create(Person entry) throws BusinessException {
		service.create(entry);
	}

	public List<Person> findAll() {
		return service.findAll();
	}

	public Person find(int id) {
		return service.find(id);
	}

	public void update(Person entity) {
		service.update(entity);
	}

	public void remove(int id) {
		service.remove(id);
	}
}

package com.redhat.example.business;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.example.dao.PersonDao;
import com.redhat.example.model.Person2;


//@Stateless
//@Named("personService")
@Model
@Transactional
public class PersonService {

	@Inject
	private PersonDao dao;
	
	public void create(Person2 e) {
		dao.create(e);
	}
	
	public List<Person2> findAll() {
		return dao.findAll();
	}

	public Person2 find(String id) {
		return dao.find(id);
	}

	public void update(Person2 entity) {
		dao.update(entity);
	}

	public void remove(String id) {
		dao.remove(id);
	}
	
}

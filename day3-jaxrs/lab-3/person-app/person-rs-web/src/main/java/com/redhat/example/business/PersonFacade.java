package com.redhat.example.business;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.example.dao.PersonDao;
import com.redhat.example.ifs.BusinessException;
import com.redhat.example.model.Person;

@Model
@Transactional
public class PersonFacade {
	@Inject Logger log;
	@Inject PersonDao dao;
	
	public void create(Person entry) throws BusinessException {
		dao.create(entry);
		
		// firstName, lastNameのどちらかに"ERROR"の文字列が含まれていたらロールバックする。
		if ((entry.getFirstName() != null && entry.getFirstName().contains("ERROR"))
				|| (entry.getLastName() != null && entry.getLastName().contains("ERROR"))) {
			throw new BusinessException("ロールバックのテスト");
		}
		log.info("エントリを保存しました。entry="+entry);
	}

	public List<Person> findAll() {
		return dao.findAll();
	}

	public Person find(int id) {
		return dao.find(id);
	}

	public void update(Person entity) {
		dao.update(entity);
	}

	public void remove(int id) {
		dao.remove(id);
	}
}

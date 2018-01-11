package com.redhat.example.service;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import com.redhat.example.dao.RecordDao;
import com.redhat.example.model.Record;

@Model
@Transactional
public class RecordService {
	@Inject Logger log;
	
	@Inject RecordDao dao;

	public void create(Record entity) {
		log.info("Creating entry: "+entity);
		dao.create(entity);
	}

	public List<Record> findAll() {
		log.info("Listing all entries.");
		return dao.findAll();
	}

	public Record find(Integer id) {
		return dao.find(id);
	}

	public void update(Record entity) {
		log.info("Updating entry: "+entity);
		dao.update(entity);
	}

	public void remove(Integer id) {
		log.info("Removing entry: id="+id);
		dao.remove(id);
	}

}

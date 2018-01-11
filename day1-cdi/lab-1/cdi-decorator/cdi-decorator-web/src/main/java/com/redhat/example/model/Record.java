package com.redhat.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.redhat.example.util.ModelBase;

@Entity
public class Record extends ModelBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String message;
	
	public Record() {}
	
	public Record(int id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}

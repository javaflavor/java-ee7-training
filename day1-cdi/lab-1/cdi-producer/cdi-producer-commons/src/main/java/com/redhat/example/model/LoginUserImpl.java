package com.redhat.example.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.redhat.example.commons.annotation.Candidate;
import com.redhat.example.util.ModelBase;

@RequestScoped
@Candidate
public class LoginUserImpl extends ModelBase implements LoginUser {
	
	String id;
	
	@PostConstruct
	void init() {
		id = "123456";
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

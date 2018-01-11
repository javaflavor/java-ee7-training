package com.redhat.example.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.redhat.example.commons.annotation.Candidate;

@RequestScoped
@Candidate
public class CustomUserImpl extends LoginUserImpl {
	
	String name;
	String mail;
	
	@PostConstruct
	void init() {
		super.init();
		name = "Foo Bar";
		mail = "foo@redhat.com";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}

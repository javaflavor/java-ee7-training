package com.redhat.example.web;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class SampleForm {
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

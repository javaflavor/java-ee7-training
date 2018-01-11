package com.redhat.example.web;

import javax.enterprise.inject.Model;

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

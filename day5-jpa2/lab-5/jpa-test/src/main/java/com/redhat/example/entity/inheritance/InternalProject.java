package com.redhat.example.entity.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="INTERNAL")
public class InternalProject extends Project {
	public InternalProject() {}
	
	public InternalProject(int id, String name) {
		super(id, name);
	}

}

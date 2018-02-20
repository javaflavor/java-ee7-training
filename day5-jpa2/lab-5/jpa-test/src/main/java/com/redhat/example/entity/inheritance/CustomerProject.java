package com.redhat.example.entity.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="CUSTOMER")
public class CustomerProject extends Project {
	String customer;
	
	public CustomerProject() {}
	
	public CustomerProject(int id, String name, String customer) {
		super(id, name);
		this.customer = customer;
	}
}

package com.redhat.example.entity.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id int id;
	String name;
	@ManyToMany(mappedBy="users")
	List<Organization> orgs;

	public User() {
		orgs = new ArrayList<>();
	}
	
	public User(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	public List<Organization> getOrgs() {
		return orgs;
	}
}

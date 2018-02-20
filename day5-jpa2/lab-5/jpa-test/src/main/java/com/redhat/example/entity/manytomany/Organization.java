package com.redhat.example.entity.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Organization {
	@Id
	int id;
	String name;
	@ManyToMany
	List<User> users;

	public Organization() {
		users = new ArrayList<>();
	}

	public Organization(int id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}
}

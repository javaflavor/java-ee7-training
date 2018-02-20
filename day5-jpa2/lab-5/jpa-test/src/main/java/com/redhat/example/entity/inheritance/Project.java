package com.redhat.example.entity.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING)    
public abstract class Project {
	@Id int id;
	String name;
	
	public Project() {}
	
	public Project(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

package com.redhat.example.entity.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeInfo {
	@Id int id;
	String info;
	
	public EmployeeInfo() {}
	
	public EmployeeInfo(int id, String info) {
		this.id = id;
		this.info = info;
	}

}

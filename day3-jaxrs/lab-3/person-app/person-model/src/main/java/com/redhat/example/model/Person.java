package com.redhat.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.redhat.example.model.json.JsonDateSerializer;

@Entity
public class Person extends ModelBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String firstName;
	String lastName;
	@JsonSerialize(using=JsonDateSerializer.class)
	Date date;
	
	public Person() {}
	
	public Person(int id, String firstName, String lastName, Date date) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
	}
	
	@NotEmpty(message="入力は必須です。")
	@Size(max=20, message="{max}文字以下で入力してください。")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@NotEmpty(message="入力は必須です。")
	@Size(max=20, message="{max}文字以下で入力してください。")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

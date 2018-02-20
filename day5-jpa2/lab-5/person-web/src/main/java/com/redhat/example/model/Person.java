package com.redhat.example.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.redhat.example.util.ModelBase;

@Entity
@Cacheable
public class Person extends ModelBase {
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String firstName;
	String lastName;
	int age;
	
	public Person() {}
	
	public Person(int id, String firstName, String lastName, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

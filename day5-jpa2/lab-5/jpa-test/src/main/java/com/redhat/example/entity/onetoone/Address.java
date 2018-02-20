package com.redhat.example.entity.onetoone;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.redhat.example.util.ModelBase;

@Embeddable
public class Address extends ModelBase {
	String street;
	String city;
	@Enumerated(EnumType.STRING) State state;
	String zip;

	public Address() {}
	
	public Address(String street, String city, State state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public State getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

}

package com.redhat.example.config;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import com.redhat.example.factory.ServiceAddressMap;
import com.redhat.example.ifs.PersonService;

@Dependent
public class Config {
	static Map<Class,String> serviceAddressMap = new HashMap<Class,String>(){{
		put(PersonService.class, "http://localhost:8080/person-rs-web/rs");
	}};
	
	@Produces @ServiceAddressMap
	Map<Class,String> getServiceAddressMap() {
		System.out.println("### map ="+serviceAddressMap);
		return serviceAddressMap;
	}

}

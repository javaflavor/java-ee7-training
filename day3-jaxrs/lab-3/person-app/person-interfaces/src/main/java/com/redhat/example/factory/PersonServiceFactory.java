package com.redhat.example.factory;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.redhat.example.ifs.PersonService;

@Dependent
public class PersonServiceFactory extends ServiceFactoryBase<PersonService> {

	@Produces
	PersonService getService(InjectionPoint injectionPoint) {
		return super.getService(injectionPoint);
	}

}

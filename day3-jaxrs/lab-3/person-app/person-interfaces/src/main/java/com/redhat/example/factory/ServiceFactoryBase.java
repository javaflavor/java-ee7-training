package com.redhat.example.factory;

import java.util.Map;

import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public abstract class ServiceFactoryBase<T> {
	
	@Inject @ServiceAddressMap
	Map<Class,String> addressMap;

	T getService(InjectionPoint injectionPoint) {
		Class<T> serviceClass = (Class<T>)injectionPoint.getType();
		System.out.println("### serviceClass = "+serviceClass);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(addressMap.get(serviceClass));
		ResteasyWebTarget rtarget = (ResteasyWebTarget) target;
		return rtarget.proxy(serviceClass);
	}

}

package com.redhat.example.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.redhat.example.commons.annotation.Candidate;
import com.redhat.example.util.ModelBase;

@RequestScoped
@Candidate
public class CustomClientHostImpl extends ModelBase implements ClientHost {
	@ToStringExclude
	@Inject HttpServletRequest request;
	
	String address;
	String hostName;
	
	@PostConstruct
	void init() {
		address = request.getRemoteAddr();
		hostName = request.getRemoteHost();
	}

	public String getAddress() {
		return address;
	}

	public String getHostName() {
		return hostName;
	}
}

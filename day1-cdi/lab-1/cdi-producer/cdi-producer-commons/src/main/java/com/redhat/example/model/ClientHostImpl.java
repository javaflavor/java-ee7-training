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
public class ClientHostImpl extends ModelBase implements ClientHost {
	@ToStringExclude
	@Inject HttpServletRequest request;
	
	String address;
	
	@PostConstruct
	void init() {
		address = request.getRemoteAddr();
	}

	@Override
	public String getAddress() {
		return address;
	}
}

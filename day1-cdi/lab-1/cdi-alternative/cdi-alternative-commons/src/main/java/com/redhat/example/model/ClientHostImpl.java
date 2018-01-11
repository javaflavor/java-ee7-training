package com.redhat.example.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.redhat.example.util.ModelBase;

@RequestScoped
@Named("clientHost")		// EL参照が必要な場合は全ての候補で同じ名前を宣言
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

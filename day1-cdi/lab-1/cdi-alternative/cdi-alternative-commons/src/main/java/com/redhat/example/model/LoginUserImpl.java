package com.redhat.example.model;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.interceptor.Interceptor;

import com.redhat.example.util.ModelBase;

@RequestScoped
@Named("loginUser")				// EL参照が必要な場合は全ての候補で同じ名前を宣言
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class LoginUserImpl extends ModelBase implements LoginUser {
	
	String id;
	
	@PostConstruct
	void init() {
		id = "123456";
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

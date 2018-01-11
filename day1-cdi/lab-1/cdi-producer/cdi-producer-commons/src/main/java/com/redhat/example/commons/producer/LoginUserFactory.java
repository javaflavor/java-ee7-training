package com.redhat.example.commons.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.redhat.example.model.LoginUser;
import com.redhat.example.model.LoginUserImpl;

@Dependent
public class LoginUserFactory extends DynamicBeanFactory<LoginUser> {
	
	@Produces @Named("loginUser")
	@Override
	public LoginUser getQualifiedBean() {
		return super.getQualifiedBean();
	}

	@Override
	public Class<?> getDefaultType() {
		return LoginUserImpl.class;
	}
}

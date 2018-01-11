package com.redhat.example.web;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.redhat.example.model.ClientHost;
import com.redhat.example.model.LoginUser;

@Model
public class Sample {
	@Inject LoginUser loginUser;
	@Inject ClientHost clientHost;

	public LoginUser getLoginUser() {
		return loginUser;
	}

	public ClientHost getClientHost() {
		return clientHost;
	}
}

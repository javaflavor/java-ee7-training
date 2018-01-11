package com.redhat.example.model;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.interceptor.Interceptor;

@RequestScoped
@Named("loginUser")		// EL参照が必要な場合は全ての候補で同じ名前を宣言
@Alternative
@Priority(Interceptor.Priority.APPLICATION+10)	// 値が大きいほど優先度が高い
public class CustomUserImpl extends LoginUserImpl {
	
	String name;
	String mail;
	
	@PostConstruct
	void init() {
		super.init();
		name = "Foo Bar";
		mail = "foo@redhat.com";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}

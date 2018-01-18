package com.redhat.example.web;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.redhat.example.util.ModelBase;
import com.redhat.example.validator.TestValidate;

@Model
public class Form extends ModelBase {
	@Inject @ToStringExclude Logger log;

	String value;
	String cancelValue;

	public void init() {	
		log.info("### Bean init() called.");
	}
	
	@TestValidate
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		log.info("### Bean setValue() called.");
		this.value = value;
	}

	public String getCancelValue() {
		return cancelValue;
	}

	public void setCancelValue(String cancelValue) {
		log.info("### Bean setCancelValue() called.");
		this.cancelValue = cancelValue;
	}
}

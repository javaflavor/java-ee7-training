package com.redhat.example.web;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.redhat.example.util.ModelBase;

@RequestScoped
@Named
public class ViewParams extends ModelBase implements Serializable {
	private static final long serialVersionUID = -6507894886752126608L;

	@Inject @ToStringExclude Logger log;

	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		log.info("### ViewParams setId() called.");
		this.id = id;
	}

}

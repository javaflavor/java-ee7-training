package com.redhat.example.web;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Bean {
	@Inject Logger log;
	
	@Inject Form form;

    public void process() {
    	log.info("### Action process() called.");
    }
    
    public void cancel() {
    	log.info("### Action cancel() called. cancelValue="+form.getCancelValue());
    }
    
    public void valueChanged() {
    	log.info("### ValueChangeListener called.");
    }
    
    public void actionCalled() {
    	log.info("### ActionListener called.");
    }
    
    public void viewed() {
    	log.info("### ViewAction called.");
    }    
}

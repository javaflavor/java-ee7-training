package com.redhat.example.converter;

import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="TestConverter")
public class TestConverter implements Converter {
	static Logger log = Logger.getLogger(TestConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	log.info("### Converter.getAsObject() called.");
    	return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
    	log.info("### Converter.getAsString() called.");
    	return value == null ? "" : value.toString();
	}
}
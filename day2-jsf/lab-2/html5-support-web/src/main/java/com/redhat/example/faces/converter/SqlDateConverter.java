package com.redhat.example.faces.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

//@FacesConverter(value="SqlDateConverter", forClass=java.sql.Date.class)
@FacesConverter(forClass=java.sql.Date.class)
public class SqlDateConverter implements Converter {
	public static final String FORMAT = "yyyy-MM-dd";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			if (value == null || value.isEmpty()) {
				return null;
			}
			return new java.sql.Date(new SimpleDateFormat(FORMAT).parse(value).getTime());
		} catch (ParseException ex) {
			throw new ConverterException(String.format("Failed to convert '%s' to Date object with format %s.", value, FORMAT));
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		return new SimpleDateFormat(FORMAT).format((java.sql.Date) value);
	}
}
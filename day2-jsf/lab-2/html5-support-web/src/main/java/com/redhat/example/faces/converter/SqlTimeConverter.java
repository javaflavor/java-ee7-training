package com.redhat.example.faces.converter;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

//@FacesConverter(value="SqlTimeConverter", forClass=Time.class)
@FacesConverter(forClass=Time.class)
public class SqlTimeConverter implements Converter {
	public static final String FORMAT = "HH:mm";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			if (value == null || value.isEmpty()) {
				return null;
			}
			return new Time(new SimpleDateFormat(FORMAT).parse(value).getTime());
		} catch (ParseException ex) {
			throw new ConverterException(String.format("Failed to convert '%s' to Date object with format %s.", value, FORMAT));
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		return new SimpleDateFormat(FORMAT).format((Time) value);
	}
}
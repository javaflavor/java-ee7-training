package com.redhat.example.model.converter;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.redhat.example.model.ActionType;

@Converter
public class ActionTypeConverter implements AttributeConverter<List<ActionType>,String> {
	GenericConverter converter = new GenericConverter();

	@Override
	public String convertToDatabaseColumn(List<ActionType> actions) {
		return converter.toString(actions);
	}

	@Override
	public List<ActionType> convertToEntityAttribute(String str) {
		return converter.toListActionType(str);
	}
}

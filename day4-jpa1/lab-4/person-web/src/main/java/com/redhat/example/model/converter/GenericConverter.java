package com.redhat.example.model.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.redhat.example.model.ActionType;

public class GenericConverter {
	public String toString(List<?> list) {
		if (list == null) return null;
        return list.stream()
        		.map(e -> e.toString())
        		.collect(Collectors.joining(", "));		
	}
	
	public List<ActionType> toListActionType(String str) {
		if (str == null) return null;
		return Arrays.asList(str.split(", *")).stream()
                .map(s -> ActionType.valueOf(s))
                .collect(Collectors.toList());		
	}

}

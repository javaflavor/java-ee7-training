package com.redhat.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.redhat.example.model.converter.ActionTypeConverter;
import com.redhat.example.util.ModelBase;

@Entity
public class Permission2 extends ModelBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Convert(converter=ActionTypeConverter.class)
    List<ActionType> actions = new ArrayList<>();
    
    public Permission2() {}
    
    public Permission2(int id, ActionType... type) {
    	this.id = id;
    	actions.addAll(Arrays.asList(type));
    }

    public Permission2(ActionType... type) {
    	actions.addAll(Arrays.asList(type));
    }
    
	public List<ActionType> getActions() {
		return actions;
	}

	public void setActions(List<ActionType> actions) {
		this.actions = actions;
	}
}

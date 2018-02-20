package com.redhat.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.redhat.example.util.ModelBase;

@Entity
public class Permission extends ModelBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
    @Transient List<ActionType> actions = new ArrayList<>();
    
    public Permission() {}
    
    public Permission(int id, ActionType... type) {
    	this.id = id;
    	actions.addAll(Arrays.asList(type));
    }

    public Permission(ActionType... type) {
    	actions.addAll(Arrays.asList(type));
    }
    
    @Access(AccessType.PROPERTY)
    public String getAction() {
        return actions.stream()
        		.map(e -> e.toString())
        		.collect(Collectors.joining(", "));
    }

    public void setAction(String str) {
        actions = str == null ? new ArrayList<ActionType>()
            : Arrays.asList(str.split(", *")).stream()
                .map(s -> ActionType.valueOf(s))
                .collect(Collectors.toList());
    }

	public List<ActionType> getActions() {
		return actions;
	}

	public void setActions(List<ActionType> actions) {
		this.actions = actions;
	}
}

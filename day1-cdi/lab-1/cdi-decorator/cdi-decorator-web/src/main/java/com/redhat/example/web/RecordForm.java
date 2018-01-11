package com.redhat.example.web;

import javax.enterprise.inject.Model;

import com.redhat.example.model.Record;

@Model
public class RecordForm extends Record {
	
	public Record toEntity() {
		return new Record(getId(), getMessage());
	}
}

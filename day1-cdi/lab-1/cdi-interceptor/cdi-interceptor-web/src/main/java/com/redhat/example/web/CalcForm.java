package com.redhat.example.web;

import javax.enterprise.inject.Model;
import javax.inject.Named;

import com.redhat.example.util.ModelBase;

@Model
@Named("form")
public class CalcForm extends ModelBase {
	int i;
	int j;
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}

}

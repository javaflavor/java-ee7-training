package com.redhat.example.web;

import javax.enterprise.inject.Model;

import com.redhat.example.annotation.Trace;

@Model
public class Calc {
	
	@Trace
	public int add(int i, int j) {
		return i + j;
	}
}

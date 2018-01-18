package com.redhat.example.web;

import java.util.Date;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.redhat.example.util.ModelBase;

@Model
public class Form extends ModelBase {
	
	String text;
	String email;
	String dateString;
	Date date;
	java.sql.Date sqldate;
	String timeString;
	java.sql.Time time;
	int range;
	String secret;
	String area;
	boolean checked;
	String[] checks;
	String[] list;
	String[] menus;
	String item;
	String menu;
	String radio;
	
	public void submit() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("入力結果", toString()));
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public java.sql.Date getSqldate() {
		return sqldate;
	}

	public void setSqldate(java.sql.Date sqldate) {
		this.sqldate = sqldate;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public java.sql.Time getTime() {
		return time;
	}

	public void setTime(java.sql.Time time) {
		this.time = time;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String[] getChecks() {
		return checks;
	}
	public void setChecks(String[] checks) {
		this.checks = checks;
	}
	public String[] getList() {
		return list;
	}
	public void setList(String[] list) {
		this.list = list;
	}
	public String[] getMenus() {
		return menus;
	}
	public void setMenus(String[] menus) {
		this.menus = menus;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}

}

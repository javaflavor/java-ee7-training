package com.redhat.example.rs.errorhandler;

public class ErrorInfo {
	String message;
	String userMessage;
	
	public ErrorInfo() {}
	
	public ErrorInfo(String message, String userMessage) {
		this.message = message;
		this.userMessage = userMessage;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

}

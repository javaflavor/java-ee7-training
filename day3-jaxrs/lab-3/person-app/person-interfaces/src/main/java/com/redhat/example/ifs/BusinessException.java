package com.redhat.example.ifs;

import javax.ws.rs.BadRequestException;

public class BusinessException extends BadRequestException {
	public BusinessException(String message) {
		super(message);
	}

}

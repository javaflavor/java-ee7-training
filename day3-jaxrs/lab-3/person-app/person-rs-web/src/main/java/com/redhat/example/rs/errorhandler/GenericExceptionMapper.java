package com.redhat.example.rs.errorhandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(final Exception exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), exception.getMessage());

		return Response.status(Status.BAD_REQUEST)
				.entity(errorInfo)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
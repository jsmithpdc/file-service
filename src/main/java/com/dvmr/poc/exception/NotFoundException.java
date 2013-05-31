package com.dvmr.poc.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.Responses;

/**
 * 
 * @author vreddy.fp
 *
 */
public class NotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(Responses.notFound().build());
	}

	public NotFoundException(String message) {
		super(Response.status(Responses.NOT_FOUND).entity(message)
				.type("text/plain").build());
	}

}

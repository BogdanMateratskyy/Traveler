package com.kidob.traveler.app.rest.exception;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.junit.Before;
import org.junit.Test;

/**
 * Verifies that {@link GlobalExceptionHandler} correctly handles application
 * 
 * @author Bogdan
 *
 */
public class GlobalExceptionHandlerTest {

	private ExceptionMapper<Exception> handler;

	@Before
	public void setup() {
		handler = new GlobalExceptionHandler();
	}

	@Test
	public void testToResponseReturnServerError() {
		Exception exception = new Exception("test");
		Response response = handler.toResponse(exception);
		assertEquals(response.getStatus(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
	}
}

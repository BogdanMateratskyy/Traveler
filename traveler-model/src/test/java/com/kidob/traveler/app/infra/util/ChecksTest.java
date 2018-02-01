package com.kidob.traveler.app.infra.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kidob.traveler.app.infra.exception.flow.InvalidParameterException;

/**
 * Verifies functionality of {@link Checks} class
 * 
 * @author Bogdan
 *
 */
public class ChecksTest {

	@Test
	public void testCheckParameterGetException() {

		try {
			Checks.checkParameter(false, "test");
			assertTrue(false);
		} catch (Exception ex) {
			assertSame(ex.getClass(), InvalidParameterException.class);
			assertEquals(ex.getMessage(), "test");
		}

	}

	@Test
	public void testCheckParameterNoException() {

		Checks.checkParameter(true, "test");
		assertTrue(true);
	}
}

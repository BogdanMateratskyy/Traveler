package com.kidob.traveler.app.service.transform.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 * 
 * @author Bogdan
 *
 */
public class CachedFieldProviderTest {

	private FieldProvider provider;

	@Before
	public void setup() {
		provider = new CachedFieldProvider();
	}

	@Test
	public void testGetFieldNamesSuccess() {
		List<String> fields = provider.getFieldNames(Source.class, Destination.class);

		assertFalse(fields.isEmpty());
		assertTrue(fields.contains("value"));
	}

	@Test
	public void testGetFieldNamesCachedSuccess() {
		List<String> fields = provider.getFieldNames(Source.class, Destination.class);
		List<String> fields2 = provider.getFieldNames(Source.class, Destination.class);

		assertFalse(fields.isEmpty());
		assertEquals(fields, fields2);
	}
}

class Source {
	int value;
}

class Destination {
	int value;
}
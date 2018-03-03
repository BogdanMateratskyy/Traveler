package com.kidob.traveler.app.infra.util;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.kidob.traveler.app.infra.exception.ConfigurationException;
import com.kidob.traveler.app.infra.exception.flow.InvalidParameterException;
import com.kidob.traveler.app.infra.util.annotation.Ignore;

/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 * 
 * @author Bogdan
 *
 */
public class ReflectionUtilTest {

	@Test
	public void testCreateInstatnceSuccess() {
		Object value = ReflectionUtil.createInstance(Source.class);
		assertNotNull(value);
	}

	@Test(expected = ConfigurationException.class)
	public void testCreateInstanceFailure() {
		ReflectionUtil.createInstance(Restricted.class);
	}

	@Test
	public void testFindSimilarFieldsSuccess() {
		List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
		assertNotNull(fields);
		assertTrue(fields.contains("value"));
	}

	@Test
	public void testCopyFieldsSuccess() {
		Source src = new Source();
		src.setValue(10);
		Destination dest = new Destination();
		List<String> fields = ReflectionUtil.findSimilarFields(src.getClass(), dest.getClass());

		ReflectionUtil.copyFields(src, dest, fields);
		assertEquals(dest.getValue(), 10);
	}

	@Test
	public void copyFindSimilarFieldsWithIgnoreSuccess() {
		List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
		assertFalse(fields.contains("ignored"));
	}

	@Test
	public void copyFindSimilarFieldsForStaticAndFinalSuccess() {
		List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
		assertFalse(fields.contains("staticField"));
		assertFalse(fields.contains("finalField"));
	}

	@Test
	public void copyFindSimilarFieldForBaseFieldSuccess() {
		List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
		assertTrue(fields.contains("baseField"));
	}

	@Test(expected = InvalidParameterException.class)
	public void copyFieldsDestinationNullFailure() {
		Source src = new Source();
		ReflectionUtil.copyFields(src, null, Collections.emptyList());
	}
}

class BaseSource {
	private int baseField;
}

class BaseDestination {
	private int baseField;
}

class Source extends BaseSource {
	private int value;

	private String text;

	@Ignore
	private int ignored = 2;

	private static int staticField;

	private final int finalField = 0;

	public void setValue(int value) {
		this.value = value;
	}
}

class Destination extends BaseDestination {
	private int value;

	private int ignored;

	private int staticField;

	private int finalField = 0;

	public int getValue() {
		return value;
	}
}

class Restricted {
	public Restricted(int value) {

	}
}
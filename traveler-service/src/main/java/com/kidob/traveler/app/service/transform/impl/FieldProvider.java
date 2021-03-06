package com.kidob.traveler.app.service.transform.impl;

import java.util.List;

import com.kidob.traveler.app.infra.util.ReflectionUtil;

/**
 * Base functionality of the field preparation
 * 
 * @author Bogdan
 *
 */
public class FieldProvider {

	public List<String> getFieldNames(Class<?> source, Class<?> dest) {
		return ReflectionUtil.findSimilarFields(source, dest);
	}
}

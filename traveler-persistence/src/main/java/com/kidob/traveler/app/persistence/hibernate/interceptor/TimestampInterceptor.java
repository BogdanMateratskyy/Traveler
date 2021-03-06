package com.kidob.traveler.app.persistence.hibernate.interceptor;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.kidob.traveler.app.model.entity.base.AbstractEntity;

/**
 * Initializes mandatory timestamp fields for the entities
 * 
 * @author Bogdan
 *
 */
public class TimestampInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 2623653605944733065L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, 
			String[] propertyNames, Type[] types) {
		
		int idx = ArrayUtils.indexOf(propertyNames, AbstractEntity.FIELD_CREATED_AT);
		if (idx >= 0) {
			state[idx] = LocalDateTime.now();
			return true;
		}
		return false;
	}

}

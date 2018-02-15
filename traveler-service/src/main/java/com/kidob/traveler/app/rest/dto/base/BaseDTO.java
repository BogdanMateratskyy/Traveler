package com.kidob.traveler.app.rest.dto.base;

import com.kidob.traveler.app.model.entity.base.AbstractEntity;

/**
 * Base class for all DTO clases
 * 
 * @author Bogdan
 *
 */
public abstract class BaseDTO<T extends AbstractEntity> {

	/**
	 * Unique entity identifier
	 */
	private int id;

	/**
	 * Should be overridden in the derived classes if additional transformation
	 * logic domain model -> DTO is needed. Overridden methods should call
	 * super.transform()
	 */
	public void transform(T t) {
		id = t.getId();
	}

	/**
	 * Should be overridden in the derived classes if additional transformation
	 * logic DTO -> domain model is needed
	 */
	public T untransform(T t) {
		t.setId(getId());
		return t;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

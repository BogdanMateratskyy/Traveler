package com.kidob.traveler.app.model.search.criteria.range;

import com.kidob.traveler.app.infra.exception.flow.InvalidParameterException;

/**
 * Pagination parameters for data retrieval operations
 * 
 * @author Bogdan
 *
 */
public class RangeCriteria {

	/**
	 * Page index (0-based)
	 */
	private final int page;

	/**
	 * Number of elements per page. Zero means that we should return all the
	 * elements
	 */
	private final int rowCount;

	public RangeCriteria(final int page, final int rowCount) {
		if (page < 0) {
			throw new InvalidParameterException("Incorrect page index: " + page);
		}
		if (rowCount < 0) {
			throw new InvalidParameterException("Incorrect row count: " + rowCount);
		}
		this.page = page;
		this.rowCount = rowCount;
	}

	public int getPage() {
		return page;
	}

	public int getRowCount() {
		return rowCount;
	}

}

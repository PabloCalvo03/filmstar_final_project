package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents the overview of a movie.
 */
public class Overview implements Serializable {

	private String value;

	/**
	 * Default constructor.
	 */
	private Overview() {
	}

	/**
	 * Constructs an Overview object with the specified value.
	 *
	 * @param value The value of the overview.
	 * @throws OverviewLengthNotValid If the length of the overview is not valid.
	 * @throws ValueError If the value is null or empty.
	 */
	public Overview(String value) throws OverviewLengthNotValid, ValueError {
		ensureIsNotEmpty(value);
		ensureOverviewLengthIsValid(value);
		this.value = value;
	}

	/**
	 * Ensures that the value is not null or empty.
	 *
	 * @param value The value to check.
	 * @throws ValueError If the value is null or empty.
	 */
	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.isEmpty()) {
			throw new ValueError(getClass().getSimpleName() + " cannot be null");
		}
	}

	/**
	 * Ensures that the length of the overview is valid.
	 *
	 * @param value The value of the overview.
	 * @throws OverviewLengthNotValid If the length of the overview is not valid.
	 */
	private void ensureOverviewLengthIsValid(String value) throws OverviewLengthNotValid {
		if (value.length() > 500) {
			throw new OverviewLengthNotValid();
		}
	}

	/**
	 * Gets the value of the overview.
	 *
	 * @return The value of the overview.
	 */
	public String value() {
		return value;
	}
}

package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents the ID of a movie.
 */
public class MovieId implements Serializable{

	private String value;

	/**
	 * Default constructor.
	 */
	public MovieId() {
	}

	/**
	 * Parameterized constructor that sets the value of the movie ID.
	 *
	 * @param value The value of the movie ID.
	 * @throws ValueError If the provided value is empty or null.
	 */
	public MovieId(String value) throws ValueError {
		ensureIsNotEmpty(value);
		this.value = value;
	}

	/**
	 * Gets the value of the movie ID.
	 *
	 * @return The value of the movie ID.
	 */
	public String value() {
		return value;
	}

	/**
	 * Ensures that the provided value is not empty or null.
	 *
	 * @param value The value to check.
	 * @throws ValueError If the value is empty or null.
	 */
	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.length() == 0 || value.equals("")) {
			throw new ValueError(getClass().getSimpleName() + " cannot be null or empty");
		}
	}
}

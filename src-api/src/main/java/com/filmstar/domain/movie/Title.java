package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents the title of a movie.
 */
public class Title implements Serializable {

	/**
	 * The title value.
	 */
	private String value;

	/**
	 * Default constructor.
	 */
	public Title() {
	}

	/**
	 * Constructor that initializes the title with a given value.
	 *
	 * @param value the title value
	 * @throws TitleLenghtNotValid if the title length is not valid
	 * @throws ValueError if the title is null or empty
	 */
	public Title(String value) throws TitleLenghtNotValid, ValueError {
		ensureIsNotEmpty(value);
		ensureTitleLengthIsValid(value);
		this.value = value;
	}

	/**
	 * Ensures that the given title value is not empty.
	 *
	 * @param value the title value to check
	 * @throws ValueError if the title is null or empty
	 */
	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.length() == 0 || value == "") {
			throw new ValueError(getClass().getSimpleName() + " cannot be null");
		}
	}

	/**
	 * Ensures that the given title value does not exceed 50 characters.
	 *
	 * @param value the title value to check
	 * @throws TitleLenghtNotValid if the title length is not valid
	 */
	private void ensureTitleLengthIsValid(String value) throws TitleLenghtNotValid {
		if (value.length() > 50) {
			throw new TitleLenghtNotValid();
		}
	}

	/**
	 * Returns the title value.
	 *
	 * @return the title value
	 */
	public String value() {
		return value;
	}
}
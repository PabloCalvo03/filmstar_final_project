package com.filmstar.domain.movie;

import java.io.Serializable;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents the ID of a movie.
 */
public class MovieId implements Serializable{

	private static final String UUID_REGEX =
        "^[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$";

    private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);

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
		ensureIsValidUUID(value);
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

	/**
     * Ensures that the provided value is a valid UUID.
     *
     * @param value The value to check.
     * @throws ValueError If the value is not a valid UUID.
     */
    private void ensureIsValidUUID(String value) throws ValueError {
        Matcher matcher = UUID_PATTERN.matcher(value);
        if (!matcher.matches()) {
            throw new ValueError(getClass().getSimpleName() + " is not a valid UUID: " + value);
        }
    }
}

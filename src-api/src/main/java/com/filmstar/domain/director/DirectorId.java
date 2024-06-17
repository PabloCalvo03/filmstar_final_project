package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.UUID;

/**
 * Represents the unique identifier of a director entity.
 */
public class DirectorId {

	private static final String UUID_REGEX =
        "^[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$";

    private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);

	private String value;

	/**
	 * Default constructor.
	 */
	public DirectorId() {

	}

	/**
	 * Parameterized constructor to initialize a DirectorId with a value.
	 *
	 * @param value The value of the director identifier.
	 */
	public DirectorId(String value) throws ValueError {
		ensureIsValidUUID(value);
		ensureIsNotEmpty(value);
		this.value = value;
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
	 * Retrieves the value of the director identifier.
	 *
	 * @return The value of the director identifier.
	 */
	public String value() {
		return value;
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

package com.filmstar.domain.user;

import java.io.Serializable;

/**
 * Represents a unique identifier for a user.
 */
public class UserId implements Serializable {

	private String value;

	/**
	 * Default constructor for UserId.
	 */
	public UserId() {
	}

	/**
	 * Constructor for UserId that takes a value.
	 *
	 * @param value the unique identifier for the user
	 */
	public UserId(String value) {
		this.value = value;
	}

	/**
	 * Returns the value of the user ID.
	 *
	 * @return the value of the user ID
	 */
	public String value() {
		return value;
	}
}
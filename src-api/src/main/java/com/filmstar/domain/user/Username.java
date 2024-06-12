package com.filmstar.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Represents a username for a user.
 */
public final class Username implements Serializable {

	private String value;

	/**
	 * Default constructor for Username.
	 */
	public Username() {
	}

	/**
	 * Constructor for Username that takes a value.
	 *
	 * @param value the username for the user
	 */
	public Username(String value) {
		this.value = value;
	}

	/**
	 * Returns the value of the username.
	 *
	 * @return the value of the username
	 */
	@JsonProperty
	public String value() {
		return value;
	}
}
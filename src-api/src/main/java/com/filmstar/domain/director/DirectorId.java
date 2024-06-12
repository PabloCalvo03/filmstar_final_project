package com.filmstar.domain.director;

/**
 * Represents the unique identifier of a director entity.
 */
public class DirectorId {

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
	public DirectorId(String value) {
		this.value = value;
	}

	/**
	 * Retrieves the value of the director identifier.
	 *
	 * @return The value of the director identifier.
	 */
	public String value() {
		return value;
	}

}

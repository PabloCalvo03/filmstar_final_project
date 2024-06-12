package com.filmstar.domain.director;

// Define a custom exception class for cases where a director is not found
public class DirectorNotFound extends Exception {

	/**
	 * Constructs a new DirectorNotFound exception with the specified ID.
	 *
	 * @param id The ID of the director that was not found.
	 */
	public DirectorNotFound(String id) {
		// Call the superclass constructor with a custom error message
		super("Director with id: " + id + " not found.");
	}

}

package com.filmstar.apps.shared;

import com.filmstar.domain.user.User;

/**
 * A class representing a serialized user in the Filmstar application.
 */
public class SerializedUser {

	public Long id;
	public String email;
	public String username;
	public String role;

	/**
	 * Constructs a SerializedUser object with the provided user details.
	 *
	 * @param id       the user ID
	 * @param email    the user email
	 * @param username the user username
	 * @param role     the user role
	 */
	public SerializedUser(Long id, String email, String username, String role) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.role = role;
	}

	/**
	 * Converts a User object to a SerializedUser object.
	 *
	 * @param user the User object to convert
	 * @return the corresponding SerializedUser object
	 */
	public static SerializedUser from(User user) {
		return new SerializedUser(user.id(), user.email().value(), user.username().value(), user.role().name());
	}

}

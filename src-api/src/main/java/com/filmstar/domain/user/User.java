package com.filmstar.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a user in the system.
 */
public final class User implements Serializable {

	private Long id;
	private Email email;
	private Username username;
	private Password password;
	private Role role;

	/**
	 * Default constructor for User.
	 */
	public User() {
	}

	/**
	 * Constructor for User that takes email, username, password, and role.
	 *
	 * @param email    the email address of the user
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param role     the role of the user
	 * @throws IllegalArgumentException if any of the parameters are invalid
	 */
	public User(Email email, Username username, Password password, Role role) throws IllegalArgumentException {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * Checks if the provided password matches the user's password.
	 *
	 * @param password the password to check
	 * @return true if the passwords match, false otherwise
	 */
	public boolean passwordMatches(final Password password) {
		return this.password.value().equals(password.value());
	}

	/**
	 * Returns the ID of the user.
	 *
	 * @return the ID of the user
	 */
	public Long id() {
		return id;
	}

	/**
	 * Returns the username of the user.
	 *
	 * @return the username of the user
	 */
	@JsonProperty
	public Username username() {
		return username;
	}

	/**
	 * Returns the password of the user.
	 *
	 * @return the password of the user
	 */
	public Password password() {
		return password;
	}

	/**
	 * Returns the role of the user.
	 *
	 * @return the role of the user
	 */
	public Role role() {
		return role;
	}

	/**
	 * Sets the ID of the user.
	 *
	 * @param id the ID to set
	 */
	public void id(Long id) {
		this.id = id;
	}

	/**
	 * Sets the username of the user.
	 *
	 * @param username the username to set
	 */
	public void username(Username username) {
		this.username = username;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password the password to set
	 */
	public void password(Password password) {
		this.password = password;
	}

	/**
	 * Sets the role of the user.
	 *
	 * @param role the role to set
	 */
	public void role(Role role) {
		this.role = role;
	}

	/**
	 * Returns the email address of the user.
	 *
	 * @return the email address of the user
	 */
	public Email email() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 *
	 * @param email the email address to set
	 */
	public void email(Email email) {
		this.email = email;
	}
}
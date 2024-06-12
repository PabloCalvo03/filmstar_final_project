package com.filmstar.domain.user;

/**
 * Provides methods for creating and validating authentication tokens.
 */
public interface AuthenticationTokenProvider {

	/**
	 * Creates a new authentication token for the given username and role.
	 *
	 * @param username the username to create the token for
	 * @param role the role of the user
	 * @return the created token
	 */
	Token createToken(Username username, Role role);

	/**
	 * Validates the given token and returns the corresponding username.
	 *
	 * @param token the token to validate
	 * @return the username associated with the token, or null if the token is invalid
	 */
	Username validateToken(Token token);
}
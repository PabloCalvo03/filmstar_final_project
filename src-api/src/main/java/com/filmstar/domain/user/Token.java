package com.filmstar.domain.user;

/**
 * Represents a token used for authentication or authorization.
 */
public class Token {

	private String value;

	/**
	 * Default constructor for Token.
	 */
	public Token() {
	}

	/**
	 * Constructor for Token that takes a token value.
	 *
	 * @param value the value of the token
	 */
	public Token(String value) {
		this.value = value;
	}

	/**
	 * Returns the value of the token.
	 *
	 * @return the value of the token
	 */
	public String value() {
		return value;
	}
}
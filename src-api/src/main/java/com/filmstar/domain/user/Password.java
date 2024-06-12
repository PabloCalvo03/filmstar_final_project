package com.filmstar.domain.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a password with security features.
 */
public final class Password implements Serializable {

	private String value;
	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{10,}$";

	/**
	 * Default constructor for Password.
	 */
	public Password() {
	}

	/**
	 * Constructor for Password that takes a decrypted password and an encrypted value.
	 *
	 * @param decryptedPassword the decrypted password to validate
	 * @param value the encrypted value of the password
	 * @throws IllegalArgumentException if the decrypted password does not meet the security requirements
	 */
	public Password(String decryptedPassword, String value) throws IllegalArgumentException{
		ensurePasswordIsValid(decryptedPassword);
		this.value = value;
	}

	/**
	 * Validates the password against the security requirements.
	 *
	 * @param password the password to validate
	 * @throws IllegalArgumentException if the password does not meet the security requirements
	 */
	private void ensurePasswordIsValid(String password) throws IllegalArgumentException{
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("The password must contain at least one uppercase letter, one lowercase letter, one number, and be at least 10 characters long");
		}
	}

	/**
	 * Returns the encrypted value of the password.
	 *
	 * @return the encrypted value of the password
	 */
	public String value() {
		return value;
	}
}
package com.filmstar.domain.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Password implements Serializable {

	private String value;
	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{10,}$";

	public Password() {
	}
	
	public Password(String decryptedPassword, String value) throws IllegalArgumentException{
		ensurePasswordIsValid(decryptedPassword);
		this.value = value;
	}

	private void ensurePasswordIsValid(String password) throws IllegalArgumentException{
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("La contraseña debe contener al menos una mayúscula, una minúscula, un número y tener al menos 10 caracteres");
		}
	}

	public String value() {
		return value;
	}
	

}

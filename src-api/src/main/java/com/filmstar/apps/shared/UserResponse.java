package com.filmstar.apps.shared;

import java.io.Serializable;

/**
 * Class representing a user response.
 */
public class UserResponse implements Serializable {
	// Attributes of the user response
	private String accessToken; // Access token
	private String expirationDate; // Expiration date of the token
	private String role; // Role of the user

	// Constructors
	public UserResponse() {
	}

	public UserResponse(String accessToken, String expirationDate, String role) {
		this.accessToken = accessToken;
		this.expirationDate = expirationDate;
		this.role = role;
	}

	// Accessor methods to get and set attribute values
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

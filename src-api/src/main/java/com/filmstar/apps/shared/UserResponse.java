package com.filmstar.apps.shared;

import java.io.Serializable;

public class UserResponse implements Serializable {
	private String accessToken;
	private String expirationDate;
	private String role;

	public UserResponse() {
	}

	public UserResponse(String accessToken, String expirationDate, String role) {
		this.accessToken = accessToken;
		this.expirationDate = expirationDate;
		this.role = role;
	}


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

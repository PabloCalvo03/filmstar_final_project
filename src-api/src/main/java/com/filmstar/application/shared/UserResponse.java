package com.filmstar.application.shared;

import java.io.Serializable;

public class UserResponse implements Serializable {
	private String accessToken;
	private String expirationDate;

	public UserResponse() {
	}

	public UserResponse(String accessToken, String expirationDate) {
		this.accessToken = accessToken;
		this.expirationDate = expirationDate;
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


}

package com.filmstar.application.shared;

public class UserResponse {
  String username;
  String token;
  
  public UserResponse() {
	  
  }
  
  public UserResponse(String username, String token) {
	  this.username = username;
	  this.token = token;
  }

	public String getUsername() {
		return username;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
  
  
}

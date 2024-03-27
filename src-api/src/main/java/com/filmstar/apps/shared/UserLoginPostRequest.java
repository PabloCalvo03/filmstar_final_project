package com.filmstar.apps.shared;

public class UserLoginPostRequest {
  String username;
  String password;
  
  public UserLoginPostRequest() {
	  
  }
  
  public UserLoginPostRequest(String username, String password) {
	  this.username = username;
	  this.password = password;
  }

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

public void setUsername(String username) {
	this.username = username;
}

public void setPassword(String password) {
	this.password = password;
}
  
  
}

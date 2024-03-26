package com.filmstar.application.shared;

public class UserRegisterRequest {
    String email;
  String username;
  String password;
  
  public UserRegisterRequest() {
	  
  }
  
  public UserRegisterRequest(String email, String username, String password) {
      this.email = email;
	  this.username = username;
	  this.password = password;
  }

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

public String getEmail() { return email; }

public void setUsername(String username) {
	this.username = username;
}

public void setPassword(String password) {
	this.password = password;
}

public void setEmail(String email) {
        this.email = email;
    }
}

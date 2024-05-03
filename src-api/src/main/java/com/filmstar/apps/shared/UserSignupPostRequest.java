package com.filmstar.apps.shared;

public class UserSignupPostRequest {
    String email;
  String username;
  String password;

  String invitationCode;
  
  public UserSignupPostRequest() {
	  
  }
  
  public UserSignupPostRequest(String email, String username, String password, String invitationCode) {
      this.email = email;
	  this.username = username;
	  this.password = password;
      this.invitationCode = invitationCode;
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

    public String getInvitationCode() {
        return invitationCode;
    }
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }
}

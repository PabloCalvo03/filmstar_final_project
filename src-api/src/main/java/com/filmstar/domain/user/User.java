package com.filmstar.domain.user;

import java.util.Set;

public final class User {
	private Long id;
	private Email email;
  private Username username;
  private Password password;
  private Role role;

  
  public User() {
	  
  }
  
  public User(Email email, Username username, Password password, Role role) {
	  this.email = email;
	  this.username = username;
	  this.password = password;
	  this.role = role;
  }

  public boolean passwordMatches(final Password password) {
    return this.password.value().equals(password.value());
  }

public Long getId() {
	return id;
}

public Username getUsername() {
	return username;
}

public Password getPassword() {
	return password;
}

public Role getRole() {
	return role;
}

public void setId(Long id) {
	this.id = id;
}

public void setUsername(Username username) {
	this.username = username;
}

public void setPassword(Password password) {
	this.password = password;
}

public void setRole(Role role) {
	this.role = role;
}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
}

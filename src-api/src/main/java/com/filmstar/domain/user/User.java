package com.filmstar.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public final class User implements Serializable {
	private Long id;
	private Email email;
  private Username username;
  private Password password;
  private Role role;

  
  public User() {
	  
  }
  
  public User(Email email, Username username, Password password, Role role) throws IllegalArgumentException{
	  this.email = email;
	  this.username = username;
	  this.password = password;
	  this.role = role;
  }

  public boolean passwordMatches(final Password password) {
    return this.password.value().equals(password.value());
  }
	public Long id() {
		return id;
	}
	@JsonProperty
	public Username username() {
	return username;
}
	public Password password() {
	return password;
}
	public Role role() {
	return role;
}

	public void id(Long id) {
	this.id = id;
}

	public void username(Username username) {
		this.username = username;
	}

	public void password(Password password) {
		this.password = password;
	}

	public void role(Role role) {
	this.role = role;
}


	public Email email() {
		return email;
	}

	public void email(Email email) {
		this.email = email;
	}
}

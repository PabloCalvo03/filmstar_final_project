package com.filmstar.domain.user;

public final class UsernameAlreadyExists extends RuntimeException {
  private static final long serialVersionUID = 1L;

public UsernameAlreadyExists(Username username) {
    super(String.format("Username <%s> already in use", username.value()));
  }
}

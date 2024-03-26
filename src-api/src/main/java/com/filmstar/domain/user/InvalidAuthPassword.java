package com.filmstar.domain.user;

public final class InvalidAuthPassword extends RuntimeException {
  public InvalidAuthPassword(final Username login) {
    super(String.format("The credentials for <%s> are invalid", login.value()));
  }
}

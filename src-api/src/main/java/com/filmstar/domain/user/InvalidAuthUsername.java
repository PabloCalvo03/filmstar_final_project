package com.filmstar.domain.user;

public final class InvalidAuthUsername extends RuntimeException {
  public InvalidAuthUsername(final Username login) {
    super(String.format("The user <%s> does not exist", login.value()));
  }
}

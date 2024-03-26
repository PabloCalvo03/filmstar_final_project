package com.filmstar.domain.user;

public final class EmailAlreadyExists extends RuntimeException {
  private static final long serialVersionUID = 1L;

public EmailAlreadyExists(Email email) {
    super(String.format("Email <%s> already in use", email.value()));
  }
}

package com.filmstar.domain.user;

/**
 * Represents a runtime exception that occurs when the authentication password is invalid.
 */
public final class InvalidAuthPassword extends RuntimeException {

  /**
   * Constructs a new InvalidAuthPassword exception with a message indicating that the credentials for the given username are invalid.
   *
   * @param login the username for which the credentials are invalid
   */
  public InvalidAuthPassword(final Username login) {
    super(String.format("The credentials for <%s> are invalid", login.value()));
  }
}
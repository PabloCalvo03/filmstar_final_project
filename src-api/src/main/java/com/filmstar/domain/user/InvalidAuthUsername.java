package com.filmstar.domain.user;

/**
 * Represents a runtime exception that occurs when the authentication username is invalid.
 */
public final class InvalidAuthUsername extends RuntimeException {

  /**
   * Constructs a new InvalidAuthUsername exception with a message indicating that the given username does not exist.
   *
   * @param login the username that does not exist
   */
  public InvalidAuthUsername(final Username login) {
    super(String.format("The user <%s> does not exist", login.value()));
  }
}
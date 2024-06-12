package com.filmstar.infrastructure.authentication;

import org.springframework.stereotype.Service;

import com.filmstar.domain.user.AuthenticationTokenProvider;
import com.filmstar.domain.user.Role;
import com.filmstar.domain.user.Username;

/**
 * Service class for creating authentication tokens.
 */
@Service
public class AuthenticationTokenCreator {

  /**
   * Authentication token provider instance.
   */
  private AuthenticationTokenProvider authenticationTokenProvider;

  /**
   * Constructor for AuthenticationTokenCreator.
   *
   * @param authenticationTokenProvider the authentication token provider instance
   */
  public AuthenticationTokenCreator(AuthenticationTokenProvider authenticationTokenProvider) {
    this.authenticationTokenProvider = authenticationTokenProvider;
  }

  /**
   * Creates an authentication token for a given username and role.
   *
   * @param username the username to create a token for
   * @param role the role of the user
   * @return the created authentication token as a string
   */
  public String createToken(String username, Role role) {
    return authenticationTokenProvider.createToken(new Username(username), role).value();
  }
}
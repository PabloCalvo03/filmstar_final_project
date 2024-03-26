package com.filmstar.application;

import org.springframework.stereotype.Service;

import com.filmstar.domain.user.AuthenticationTokenProvider;
import com.filmstar.domain.user.Role;
import com.filmstar.domain.user.Username;

@Service
public class AuthenticationTokenCreator {
	
  private AuthenticationTokenProvider authenticationTokenProvider;
  
  public AuthenticationTokenCreator(AuthenticationTokenProvider authenticationTokenProvider) {
	  this.authenticationTokenProvider = authenticationTokenProvider;
  }

  public String createToken(String username, Role role) {
    return authenticationTokenProvider.createToken(new Username(username), role).value();
  }
}

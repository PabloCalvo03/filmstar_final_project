package com.filmstar.domain.user;


public interface AuthenticationTokenProvider {

	  Token createToken(Username username, Role role);

	  Username validateToken(Token token);
	}
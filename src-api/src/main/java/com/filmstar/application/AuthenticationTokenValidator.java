package com.filmstar.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.filmstar.domain.user.AuthenticationTokenProvider;
import com.filmstar.domain.user.Token;
import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserRepository;
import com.filmstar.domain.user.Username;

@Service
public class AuthenticationTokenValidator {

	private AuthenticationTokenProvider authenticationTokenProvider;
	private UserRepository userRepository;

	public AuthenticationTokenValidator(
		AuthenticationTokenProvider authenticationTokenProvider,
		UserRepository userRepository
	) {
		this.authenticationTokenProvider = authenticationTokenProvider;
		this.userRepository = userRepository;
	}

	public User validateToken(final String token) {

		final Username username = authenticationTokenProvider.validateToken(new Token(token));

		final Optional<User> user = userRepository.findByUsername(username);

		return user.get();
	}
}
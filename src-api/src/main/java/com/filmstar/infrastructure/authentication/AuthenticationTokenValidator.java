package com.filmstar.infrastructure.authentication;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.filmstar.domain.user.AuthenticationTokenProvider;
import com.filmstar.domain.user.Token;
import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserRepository;
import com.filmstar.domain.user.Username;

/**
 * Service class for validating authentication tokens.
 */
@Service
public class AuthenticationTokenValidator {

	/**
	 * Authentication token provider instance.
	 */
	private AuthenticationTokenProvider authenticationTokenProvider;

	/**
	 * User repository instance.
	 */
	private UserRepository userRepository;

	/**
	 * Constructor for AuthenticationTokenValidator.
	 *
	 * @param authenticationTokenProvider the authentication token provider instance
	 * @param userRepository the user repository instance
	 */
	public AuthenticationTokenValidator(
			AuthenticationTokenProvider authenticationTokenProvider,
			UserRepository userRepository
	) {
		this.authenticationTokenProvider = authenticationTokenProvider;
		this.userRepository = userRepository;
	}

	/**
	 * Validates an authentication token and returns the corresponding user.
	 *
	 * @param token the authentication token to validate
	 * @return the user associated with the token
	 */
	public User validateToken(final String token) {

		final Username username = authenticationTokenProvider.validateToken(new Token(token));

		final Optional<User> user = userRepository.findByUsername(username);

		return user.get();
	}
}
package com.filmstar.infrastructure.persistence.jpa;

import java.util.Optional;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * JPA-based implementation of the UserRepository interface.
 */
@Repository
public class JpaUserRepository implements UserRepository {

	/**
	 * Autowired instance of the JpaBridgeUserRepository.
	 */
	@Autowired
	private JpaBridgeUserRepository userRepository;

	/**
	 * Finds a user by their username.
	 *
	 * @param username the username of the user to find
	 * @return an optional containing the user if found, or an empty optional if not found
	 */
	@Override
	public Optional<User> findByUsername(Username username) {
		return userRepository.findByUsername(username);
	}

	/**
	 * Finds a user by their email.
	 *
	 * @param email the email of the user to find
	 * @return an optional containing the user if found, or an empty optional if not found
	 */
	@Override
	public Optional<User> findByEmail(Email email) {
		return userRepository.findByEmail(email);
	}

	/**
	 * Finds a user by their username, or throws a UserNotFound exception if not found.
	 *
	 * @param username the username of the user to find
	 * @return the user if found
	 * @throws UserNotFound if the user is not found
	 */
	@Override
	public User findByUsernameOrFail(Username username) throws UserNotFound {
		return this.findByUsername(username).orElseThrow(() -> new UserNotFound(username.value()));
	}

	/**
	 * Saves a user.
	 *
	 * @param user the user to save
	 */
	@Override
	public void save(final User user) {
		userRepository.save(user);
	}
}
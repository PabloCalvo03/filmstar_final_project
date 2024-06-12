package com.filmstar.domain.user;

import com.filmstar.domain.movie.Movie;

import java.util.Optional;

/**
 * Repository interface for user data access.
 */
public interface UserRepository {

  /**
   * Finds a user by their username.
   *
   * @param username the username to search for
   * @return an Optional containing the user if found, or an empty Optional if not found
   */
  Optional<User> findByUsername(Username username);

  /**
   * Finds a user by their email.
   *
   * @param email the email to search for
   * @return an Optional containing the user if found, or an empty Optional if not found
   */
  Optional<User> findByEmail(Email email);

  /**
   * Finds a user by their username, or throws a UserNotFound exception if not found.
   *
   * @param username the username to search for
   * @return the user if found
   * @throws UserNotFound if the user is not found
   */
  User findByUsernameOrFail(Username username) throws UserNotFound;

  /**
   * Saves a user to the repository.
   *
   * @param user the user to save
   */
  void save(User user);
}
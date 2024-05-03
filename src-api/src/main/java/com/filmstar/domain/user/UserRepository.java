package com.filmstar.domain.user;

import com.filmstar.domain.movie.Movie;

import java.util.Optional;

public interface UserRepository {
  Optional<User> findByUsername(Username username);

  Optional<User> findByEmail(Email email);

    User findByUsernameOrFail(Username id) throws UserNotFound;

    void save(User user);
}

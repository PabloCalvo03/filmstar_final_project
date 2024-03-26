package com.filmstar.domain.user;

import java.util.Optional;

public interface UserRepository {
  Optional<User> findByUsername(Username username);

  Optional<User> findByEmail(Email email);

  void save(User user);
}

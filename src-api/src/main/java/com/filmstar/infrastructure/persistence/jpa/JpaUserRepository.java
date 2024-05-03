package com.filmstar.infrastructure.persistence.jpa;

import java.util.Optional;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository implements UserRepository{
	
	@Autowired
	private JpaBridgeUserRepository userRepository;

	@Override
	public Optional<User> findByUsername(Username username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findByEmail(Email email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByUsernameOrFail(Username username) throws UserNotFound {
		return this.findByUsername(username).orElseThrow(()-> new UserNotFound(username.value()));
	}

	@Override
	  public void save(final User user) {
	    userRepository.save(user);
	  }

}

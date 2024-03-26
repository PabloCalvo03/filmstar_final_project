package com.filmstar.infrastructure.persistence.jpa;

import java.util.Optional;

import com.filmstar.domain.user.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserRepository;
import com.filmstar.domain.user.Username;

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
	  public void save(final User user) {
	    userRepository.save(user);
	  }

}

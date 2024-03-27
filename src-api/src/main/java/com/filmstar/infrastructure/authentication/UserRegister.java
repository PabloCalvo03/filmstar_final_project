package com.filmstar.infrastructure.authentication;

import java.util.Optional;

import com.filmstar.domain.user.*;
import com.filmstar.infrastructure.authentication.AuthenticationTokenCreator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmstar.application.shared.UserRegisterRequest;
import com.filmstar.application.shared.UserResponse;

@Service
public class UserRegister {
  private UserRepository userRepository;
  private AuthenticationTokenCreator authenticationTokenCreator;
  private BCryptPasswordEncoder passwordEncoder;


  public UserRegister(UserRepository userRepository, AuthenticationTokenCreator authenticationTokenCreator) {
	  this.userRepository = userRepository;
	  this.authenticationTokenCreator = authenticationTokenCreator;
	  this.passwordEncoder = new BCryptPasswordEncoder();
  }

  public UserResponse register(UserRegisterRequest userRegisterRequest) {
    String encryptedPassword = passwordEncoder.encode(userRegisterRequest.getPassword());

    final Optional<User> existingUserByEmail = userRepository.findByEmail(new Email(userRegisterRequest.getEmail()));
    final Optional<User> existingUserByUsername = userRepository.findByUsername(new Username(userRegisterRequest.getUsername()));

    ensureUserDoesNotExist(existingUserByUsername, existingUserByEmail,
            new Username(userRegisterRequest.getUsername()),
            new Email(userRegisterRequest.getEmail()));

    final User newUser = new User(
            new Email(userRegisterRequest.getEmail()),
            new Username(userRegisterRequest.getUsername()),
            new Password(encryptedPassword),
            Role.USER);

    userRepository.save(newUser);

    return new UserResponse(
            newUser.getUsername().value(),
            authenticationTokenCreator.createToken(newUser.getUsername().value(), newUser.getRole()));
  }

  public void ensureUserDoesNotExist(Optional<User> userByUsername, Optional<User> userByEmail,
                                     Username username, Email email) {
    if (userByUsername.isPresent()) {
      throw new UsernameAlreadyExists(username);
    } else if (userByEmail.isPresent()) {
      throw new EmailAlreadyExists(email);
    }
  }

}

package com.filmstar.infrastructure.authentication;

import java.util.Optional;

import com.filmstar.domain.user.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmstar.apps.shared.UserSignupPostRequest;
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

  public UserResponse register(UserSignupPostRequest userSignupPostRequest) {
    String encryptedPassword = passwordEncoder.encode(userSignupPostRequest.getPassword());

    final Optional<User> existingUserByEmail = userRepository.findByEmail(new Email(userSignupPostRequest.getEmail()));
    final Optional<User> existingUserByUsername = userRepository.findByUsername(new Username(userSignupPostRequest.getUsername()));

    ensureUserDoesNotExist(existingUserByUsername, existingUserByEmail,
            new Username(userSignupPostRequest.getUsername()),
            new Email(userSignupPostRequest.getEmail()));

    final User newUser = new User(
            new Email(userSignupPostRequest.getEmail()),
            new Username(userSignupPostRequest.getUsername()),
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

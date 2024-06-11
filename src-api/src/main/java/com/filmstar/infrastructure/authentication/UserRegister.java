package com.filmstar.infrastructure.authentication;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

import com.filmstar.domain.user.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmstar.apps.shared.UserSignupPostRequest;
import com.filmstar.apps.shared.UserResponse;

@Service
public class UserRegister {
  private UserRepository userRepository;
  private AuthenticationTokenCreator authenticationTokenCreator;

  private InvitationRepository invitationRepository;
  private BCryptPasswordEncoder passwordEncoder;


  public UserRegister(UserRepository userRepository, AuthenticationTokenCreator authenticationTokenCreator, InvitationRepository invitationRepository) {
	  this.userRepository = userRepository;
	  this.authenticationTokenCreator = authenticationTokenCreator;
	  this.passwordEncoder = new BCryptPasswordEncoder();
      this.invitationRepository = invitationRepository;
  }

  public UserResponse register(UserSignupPostRequest userSignupPostRequest) throws IllegalArgumentException, EmailAlreadyExists, UsernameAlreadyExists, InvitationNotFound, BadInvitation {
    String password = userSignupPostRequest.getPassword();
    String encryptedPassword = passwordEncoder.encode(password);

    String invitationCode = userSignupPostRequest.getInvitationCode();
    Invitation invitation = invitationRepository.findByCodeOrFail(invitationCode);
    
    if (invitation.isUsed() || invitation.getExpirationDate().isBefore(LocalDateTime.now())) {
        throw new BadInvitation();
    }


    final Optional<User> existingUserByEmail = userRepository.findByEmail(new Email(userSignupPostRequest.getEmail()));
    final Optional<User> existingUserByUsername = userRepository.findByUsername(new Username(userSignupPostRequest.getUsername()));

    ensureUserDoesNotExist(existingUserByUsername, existingUserByEmail,
            new Username(userSignupPostRequest.getUsername()),
            new Email(userSignupPostRequest.getEmail()));

    final User newUser = new User(
            new Email(userSignupPostRequest.getEmail()),
            new Username(userSignupPostRequest.getUsername()),
            new Password(password, encryptedPassword),
            Role.USER);

    invitation.setUsed(true);
    
    invitationRepository.save(invitation);
    userRepository.save(newUser);

    Instant expirationInstant = Instant.now().plusMillis(3600000);
    String expirationDate = expirationInstant.toString();
    return new UserResponse(
            authenticationTokenCreator.createToken(newUser.username().value(), newUser.role())
    , expirationDate, newUser.role().name());
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

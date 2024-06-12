package com.filmstar.infrastructure.authentication;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

import com.filmstar.domain.user.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmstar.apps.shared.UserSignupPostRequest;
import com.filmstar.apps.shared.UserResponse;
import com.filmstar.domain.user.InvitationRepository;
/**
 * Service class for registering new users.
 */
@Service
public class UserRegister {
  /**
   * Repository for users.
   */
  private UserRepository userRepository;

  /**
   * Creator for authentication tokens.
   */
  private AuthenticationTokenCreator authenticationTokenCreator;

  /**
   * Repository for invitations.
   */
  private InvitationRepository invitationRepository;

  /**
   * Encoder for passwords.
   */
  private BCryptPasswordEncoder passwordEncoder;

  /**
   * Constructor for UserRegister.
   *
   * @param userRepository repository for users
   * @param authenticationTokenCreator creator for authentication tokens
   * @param invitationRepository repository for invitations
   */
  public UserRegister(UserRepository userRepository, AuthenticationTokenCreator authenticationTokenCreator, InvitationRepository invitationRepository) {
    this.userRepository = userRepository;
    this.authenticationTokenCreator = authenticationTokenCreator;
    this.passwordEncoder = new BCryptPasswordEncoder();
    this.invitationRepository = invitationRepository;
  }

  /**
   * Registers a new user and returns a response with an authentication token.
   *
   * @param userSignupPostRequest request for user signup
   * @return response with authentication token
   * @throws IllegalArgumentException if the request is invalid
   * @throws EmailAlreadyExists if the email is already in use
   * @throws UsernameAlreadyExists if the username is already in use
   * @throws InvitationNotFound if the invitation code is not found
   * @throws BadInvitation if the invitation is invalid or expired
   */
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

  /**
   * Ensures that a user with the given username and email does not exist.
   *
   * @param userByUsername optional user with the given username
   * @param userByEmail optional user with the given email
   * @param username username to check
   * @param email email to check
   * @throws UsernameAlreadyExists if a user with the given username exists
   * @throws EmailAlreadyExists if a user with the given email exists
   */
  public void ensureUserDoesNotExist(Optional<User> userByUsername, Optional<User> userByEmail,
                                     Username username, Email email) {
    if (userByUsername.isPresent()) {
      throw new UsernameAlreadyExists(username);
    } else if (userByEmail.isPresent()) {
      throw new EmailAlreadyExists(email);
    }
  }
}
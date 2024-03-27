package com.filmstar.infrastructure.authentication;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmstar.apps.shared.UserLoginPostRequest;
import com.filmstar.application.shared.UserResponse;
import com.filmstar.domain.user.InvalidAuthPassword;
import com.filmstar.domain.user.InvalidAuthUsername;
import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserRepository;
import com.filmstar.domain.user.Username;

@Service
public class UserAuthenticator {
    private UserRepository userRepository;
    private AuthenticationTokenCreator authenticationTokenCreator;
    private BCryptPasswordEncoder passwordEncoder;

    public UserAuthenticator(UserRepository userRepository, AuthenticationTokenCreator authenticationTokenCreator) {
        this.userRepository = userRepository;
        this.authenticationTokenCreator = authenticationTokenCreator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserResponse authenticate(UserLoginPostRequest userLoginPostRequest) {
        final Optional<User> user = userRepository.findByUsername(new Username(userLoginPostRequest.getUsername()));

        ensureUserExist(user, new Username(userLoginPostRequest.getUsername()));
        ensureCredentialsAreValid(user.get(), userLoginPostRequest.getPassword());

        return new UserResponse(
                user.get().getUsername().value(),
                authenticationTokenCreator.createToken(user.get().getUsername().value(), user.get().getRole()));
    }

    private void ensureUserExist(final Optional<User> user, final Username username) {
        if (!user.isPresent()) {
            throw new InvalidAuthUsername(username);
        }
    }

    private void ensureCredentialsAreValid(final User user, final String password) {
        // Comparar la contraseña proporcionada por el usuario con la contraseña encriptada almacenada en la base de datos
        if (!passwordEncoder.matches(password, user.getPassword().value())) {
            throw new InvalidAuthPassword(user.getUsername());
        }
    }

}

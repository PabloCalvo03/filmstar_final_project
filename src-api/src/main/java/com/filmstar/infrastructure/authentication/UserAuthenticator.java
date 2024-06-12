package com.filmstar.infrastructure.authentication;

import java.time.Instant;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmstar.apps.shared.UserLoginPostRequest;
import com.filmstar.apps.shared.UserResponse;
import com.filmstar.domain.user.InvalidAuthPassword;
import com.filmstar.domain.user.InvalidAuthUsername;
import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserRepository;
import com.filmstar.domain.user.Username;

/**
 * Servitium authenticandi utentium.
 */
@Service
public class UserAuthenticator {
    /**
     * Repositorium utentium.
     */
    private UserRepository userRepository;

    /**
     * Creator tokenium authenticandi.
     */
    private AuthenticationTokenCreator authenticationTokenCreator;

    /**
     * Codex encryptandi passwordum.
     */
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Constructor UserAuthenticator.
     *
     * @param userRepository repositorium utentium
     * @param authenticationTokenCreator creator tokenium authenticandi
     */
    public UserAuthenticator(UserRepository userRepository, AuthenticationTokenCreator authenticationTokenCreator) {
        this.userRepository = userRepository;
        this.authenticationTokenCreator = authenticationTokenCreator;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Authenticat utentem et reddat responsa utentis.
     *
     * @param userLoginPostRequest petitio utentis
     * @return responsa utentis
     */
    public UserResponse authenticate(UserLoginPostRequest userLoginPostRequest) {
        final Optional<User> user = userRepository.findByUsername(new Username(userLoginPostRequest.getUsername()));

        ensureUserExist(user, new Username(userLoginPostRequest.getUsername()));
        ensureCredentialsAreValid(user.get(), userLoginPostRequest.getPassword());

        Instant expirationInstant = Instant.now().plusMillis(3600000);
        String expirationDate = expirationInstant.toString();

        return new UserResponse(
                authenticationTokenCreator.createToken(user.get().username().value(), user.get().role())
                , expirationDate, user.get().role().name());
    }

    /**
     * Certificat utentem existere.
     *
     * @param user optionalis utentis
     * @param username nomen utentis
     */
    private void ensureUserExist(final Optional<User> user, final Username username) {
        if (!user.isPresent()) {
            throw new InvalidAuthUsername(username);
        }
    }

    /**
     * Certificat credentiales esse validas.
     *
     * @param user utentis
     * @param password passwordum utentis
     */
    private void ensureCredentialsAreValid(final User user, final String password) {
        // Comparar la contraseña proporcionada por el usuario con la contraseña encriptada almacenada en la base de datos
        if (!passwordEncoder.matches(password, user.password().value())) {
            throw new InvalidAuthPassword(user.username());
        }
    }

}
package com.filmstar.domain.user;

/**
 * Exception thrown when a username already exists.
 */
public final class UsernameAlreadyExists extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new UsernameAlreadyExists exception with a message indicating that the specified username is already in use.
     *
     * @param username the username that already exists
     */
    public UsernameAlreadyExists(Username username) {
        super(String.format("Username <%s> already in use", username.value()));
    }
}
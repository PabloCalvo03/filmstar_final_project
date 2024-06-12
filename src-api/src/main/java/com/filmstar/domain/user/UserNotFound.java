package com.filmstar.domain.user;

/**
 * Exception thrown when a user is not found.
 */
public class UserNotFound extends Exception {

    /**
     * Constructs a new UserNotFound exception with a message indicating that the user with the specified username was not found.
     *
     * @param username the username of the user that was not found
     */
    public UserNotFound(String username) {
        super("User with username: " + username + " not found.");
    }
}
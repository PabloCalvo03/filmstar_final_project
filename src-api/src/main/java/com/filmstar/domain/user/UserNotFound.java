package com.filmstar.domain.user;

public class UserNotFound extends Exception {
    public UserNotFound(String username) {
        super("User with username: " + username + " not found.");
    }

}

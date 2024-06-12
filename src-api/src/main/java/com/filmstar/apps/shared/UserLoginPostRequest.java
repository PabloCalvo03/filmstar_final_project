package com.filmstar.apps.shared;

/**
 * Class representing a user login request.
 */
public class UserLoginPostRequest {
    // Attributes of the login request
    String username; // Username
    String password; // Password

    // Constructors
    public UserLoginPostRequest() {

    }

    public UserLoginPostRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Accessor methods to get and set attribute values
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

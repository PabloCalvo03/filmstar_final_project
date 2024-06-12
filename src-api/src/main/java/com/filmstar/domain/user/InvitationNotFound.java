package com.filmstar.domain.user;

/**
 * Represents an exception that occurs when an invitation with a given code is not found.
 */
public class InvitationNotFound extends Exception {

    /**
     * Constructs a new InvitationNotFound exception with a message indicating that an invitation with the given code was not found.
     *
     * @param code the code of the invitation that was not found
     */
    public InvitationNotFound(String code) {
        super("Invitation with code: " + code + " not found.");
    }
}
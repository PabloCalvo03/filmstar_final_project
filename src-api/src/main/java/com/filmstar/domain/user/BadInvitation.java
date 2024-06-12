package com.filmstar.domain.user;

/**
 * Represents an exception that occurs when an invitation is no longer valid.
 */
public class BadInvitation extends Exception {

    /**
     * Constructs a new BadInvitation exception with a default error message.
     */
    public BadInvitation() {
        super("La invitacion proporcionada ya no es valida");
    }
}
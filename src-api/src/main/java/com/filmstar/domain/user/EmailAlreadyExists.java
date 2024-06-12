package com.filmstar.domain.user;

/**
 * Represents a runtime exception that occurs when an email address already exists.
 */
public final class EmailAlreadyExists extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new EmailAlreadyExists exception with a message indicating that the given email address is already in use.
     *
     * @param email the email address that already exists
     */
    public EmailAlreadyExists(Email email) {
        super(String.format("Email <%s> already in use", email.value()));
    }
}
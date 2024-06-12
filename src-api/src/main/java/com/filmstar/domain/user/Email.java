package com.filmstar.domain.user;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents an email address.
 */
public final class Email implements Serializable {

    private String value;

    /**
     * Constructs a new Email object with no initial value.
     */
    public Email() {
    }

    /**
     * Constructs a new Email object with the given value.
     *
     * @param value the email address
     * @throws IllegalArgumentException if the email address is not valid
     */
    public Email(String value) throws IllegalArgumentException{
        ensureEmailIsValid(value);
        this.value = value;
    }

    /**
     * Returns the value of the email address.
     *
     * @return the email address
     */
    public String value() {
        return value;
    }

    /**
     * Ensures that the given email address is valid.
     *
     * @param value the email address to validate
     * @throws IllegalArgumentException if the email address is not valid
     */
    private void ensureEmailIsValid(String value) throws IllegalArgumentException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Email address is not valid");
        }
    }
}
package com.filmstar.domain.user;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Email implements Serializable {

    private String value;

    public Email() {
    }

    public Email(String value) throws IllegalArgumentException{
        ensureEmailIsValid(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void ensureEmailIsValid(String value) throws IllegalArgumentException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Email address is not valid");
        }
    }
}

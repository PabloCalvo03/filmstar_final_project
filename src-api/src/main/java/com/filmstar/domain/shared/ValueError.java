package com.filmstar.domain.shared;

/**
 * Represents an error that occurs when a value is invalid.
 */
public class ValueError extends Exception {

    /**
     * Constructs a new ValueError with the given message.
     *
     * @param message the error message
     */
    public ValueError(String message) {
        super(message);
    }
}
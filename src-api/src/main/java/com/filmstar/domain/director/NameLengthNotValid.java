package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents an error indicating that the length of a director's name is not valid.
 * Extends the ValueError class.
 */
public class NameLengthNotValid extends ValueError {

    /**
     * Constructs a NameLengthNotValid object with a default error message.
     */
    public NameLengthNotValid() {
        // Call the superclass constructor with a custom error message
        super("The length of the name must be less than 20");
    }
}

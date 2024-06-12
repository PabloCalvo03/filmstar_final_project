package com.filmstar.domain.movie;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents an error when the length of a title is not valid.
 */
public class TitleLenghtNotValid extends ValueError {

    /**
     * Constructor that initializes the error message.
     */
    public TitleLenghtNotValid() {
        super("The length of the title must be less than 20");
    }
}
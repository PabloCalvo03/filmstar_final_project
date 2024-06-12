package com.filmstar.domain.movie;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents a value error when the length of a movie's overview is too long.
 *
 * @see ValueError
 */
public class OverviewLengthNotValid extends ValueError {

    /**
     * Constructor that initializes the exception with a default error message.
     *
     * The error message indicates that the length of the overview must be less than 500 characters.
     */
    public OverviewLengthNotValid(){
        super("The length of the value must be less than 500");
    }
}
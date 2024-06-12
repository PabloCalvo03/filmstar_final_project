package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

/**
 * Custom exception class for cases where the length of a surname is not valid.
 */
public class SurnameLengthNotValid extends ValueError {

    /**
     * Default constructor that sets a predefined error message.
     */
    public SurnameLengthNotValid() {
        super("The length of the surname must be less than 20");
    }
}

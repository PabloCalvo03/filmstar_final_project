package com.filmstar.domain.movie;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents a year.
 */
public class Year {

    /**
     * The value of the year.
     */
    private Integer value;

    /**
     * Default constructor.
     */
    public Year() {
    }

    /**
     * Constructor that initializes the year with a given value.
     *
     * @param value the year value
     * @throws ValueError if the value is null or not a valid year
     */
    public Year(Integer value) throws ValueError {
        ensureIsNotEmpty(value);
        ensureIsAValidYear(value);
        this.value = value;
    }

    /**
     * Returns the value of the year.
     *
     * @return the year value
     */
    public Integer value() {
        return value;
    }

    /**
     * Ensures that the given value is not null.
     *
     * @param value the value to check
     * @throws ValueError if the value is null
     */
    private void ensureIsNotEmpty(Integer value) throws ValueError {
        if (value == null) {
            throw new ValueError(getClass().getSimpleName() + " cannot be null");
        }
    }

    /**
     * Ensures that the given value is a valid year (between 1000 and 9999).
     *
     * @param value the value to check
     * @throws ValueError if the value is not a valid year
     */
    private void ensureIsAValidYear(Integer value) throws ValueError {
        if (value < 1000 || value > 9999) {
            throw new ValueError(getClass().getSimpleName() + " is not a valid year");
        }
    }
}
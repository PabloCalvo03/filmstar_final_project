package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

import java.io.Serializable;

/**
 * Represents the surname of a director.
 */
public class Surname implements Serializable {
    private String value;

    /**
     * Default constructor.
     */
    public Surname() {
    }

    /**
     * Parameterized constructor that initializes the surname value.
     *
     * @param value The surname value to set.
     * @throws ValueError If the surname value is empty or null.
     */
    public Surname(String value) throws ValueError {
        ensureIsNotEmpty(value);
        ensureSurnameLengthIsValid(value);
        this.value = value;
    }

    /**
     * Ensures that the surname value is not empty or null.
     *
     * @param value The surname value to check.
     * @throws ValueError If the surname value is empty or null.
     */
    private void ensureIsNotEmpty(String value) throws ValueError {
        if (value == null || value.isEmpty()) {
            throw new ValueError(getClass().getSimpleName() + " cannot be null or empty");
        }
    }

    /**
     * Ensures that the length of the surname is valid.
     *
     * @param surname The surname value to check.
     * @throws SurnameLengthNotValid If the length of the surname exceeds the maximum allowed length.
     */
    private void ensureSurnameLengthIsValid(String surname) throws SurnameLengthNotValid {
        if (surname.length() > 30) {
            throw new SurnameLengthNotValid();
        }
    }

    /**
     * Gets the value of the surname.
     *
     * @return The surname value.
     */
    public String value() {
        return value;
    }
}

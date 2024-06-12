package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

import java.io.Serializable;

/**
 * Represents the name of a director.
 */
public class Name implements Serializable {
    private String value;

    /**
     * Default constructor.
     */
    public Name() {

    }

    /**
     * Constructs a Name object with the specified value.
     *
     * @param value The name value.
     * @throws ValueError If the provided name is empty or null.
     * @throws NameLengthNotValid If the length of the name exceeds the maximum allowed length.
     */
    public Name(String value) throws ValueError, NameLengthNotValid {
        ensureIsNotEmpty(value);
        ensureNameLengthIsValid(value);
        this.value = value;
    }

    /**
     * Ensures that the provided value is not empty.
     *
     * @param value The value to check.
     * @throws ValueError If the value is empty or null.
     */
    private void ensureIsNotEmpty(String value) throws ValueError {
        if (value == null || value.length() == 0 || value.equals("")) {
            throw new ValueError(getClass().getSimpleName() + " cannot be null");
        }
    }

    /**
     * Ensures that the length of the name is valid.
     *
     * @param name The name to check.
     * @throws NameLengthNotValid If the length of the name exceeds the maximum allowed length.
     */
    private void ensureNameLengthIsValid(String name) throws NameLengthNotValid {
        if (name.length() > 30) {
            throw new NameLengthNotValid();
        }
    }

    /**
     * Retrieves the value of the name.
     *
     * @return The name value.
     */
    public String value() {
        return value;
    }
}

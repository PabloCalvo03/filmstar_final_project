package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

import java.io.Serializable;

public class Surname implements Serializable {
    private String value;

    public Surname(){

    }

    public Surname(String value) throws ValueError {
        ensureIsNotEmpty(value);
        ensureSurnameLengthIsValid(value);
        this.value = value;
    }

    private void ensureIsNotEmpty(String value) throws ValueError {
        if (value == null ||value.length() == 0 || value == "") {
            throw new ValueError(getClass().getSimpleName() + " cannot be null");
        }
    }

    private void ensureSurnameLengthIsValid(String surname) throws SurnameLengthNotValid {
        if(surname.length() > 30){
            throw new SurnameLengthNotValid();
        }
    }

    public String value() {
        return value;
    }
}

package com.filmstar.domain.director;

import java.io.Serializable;

public class Surname implements Serializable {
    private String value;

    public Surname(){

    }

    public Surname(String value) throws SurnameLengthNotValid {
        ensureSurnameLengthIsValid(value);
        this.value = value;
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

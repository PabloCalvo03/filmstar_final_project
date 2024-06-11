package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

import java.io.Serializable;

public class Name implements Serializable {
    private String value;

    public Name(){

    }

    public Name(String value) throws ValueError {
        ensureIsNotEmpty(value);
        ensureNameLengthIsValid(value);
        this.value = value;
    }

    private void ensureIsNotEmpty(String value) throws ValueError {
        if (value == null ||value.length() == 0 || value == "") {
            throw new ValueError(getClass().getSimpleName() + " cannot be null");
        }
    }

    private void ensureNameLengthIsValid(String name) throws NameLengthNotValid {
        if(name.length() > 30){
            throw new NameLengthNotValid();
        }
    }

    public String value() {
        return value;
    }
}

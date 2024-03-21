package com.filmstar.domain.director;

import java.io.Serializable;

public class Name implements Serializable {
    private String value;

    public Name(){

    }

    public Name(String value) throws NameLengthNotValid {
        ensureNameLengthIsValid(value);
        this.value = value;
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

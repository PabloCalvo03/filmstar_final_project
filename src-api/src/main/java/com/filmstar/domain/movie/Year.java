package com.filmstar.domain.movie;

import com.filmstar.domain.shared.ValueError;

public class Year {

    private String value;
    
    public Year() {
    	
    }

    public Year(String value) throws ValueError{
		ensureIsNotEmpty(value);
    	ensureIsAValidYear(value);
    	this.value = value;
    }

    public String value(){
        return value;
    }
    
    private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.length() == 0 || value == "") {
			throw new ValueError(getClass().getSimpleName() + " cannot be null");
		}
	}
    
    private void ensureIsAValidYear(String value) throws ValueError {
    	if (value.length() < 4) {
			throw new ValueError(getClass().getSimpleName() + " is not a valid year");
		}
    }

}

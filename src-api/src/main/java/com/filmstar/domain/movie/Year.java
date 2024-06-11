package com.filmstar.domain.movie;

import com.filmstar.domain.shared.ValueError;

public class Year {

    private Integer value;
    
    public Year() {
    	
    }

    public Year(Integer value) throws ValueError{
		ensureIsNotEmpty(value);
    	ensureIsAValidYear(value);
    	this.value = value;
    }

    public Integer value(){
        return value;
    }
    
    private void ensureIsNotEmpty(Integer value) throws ValueError {
		if (value == null) {
			throw new ValueError(getClass().getSimpleName() + " cannot be null");
		}
	}
    
    private void ensureIsAValidYear(Integer value) throws ValueError {
    	if (value < 1000 || value > 9999) {
			throw new ValueError(getClass().getSimpleName() + " is not a valid year");
		}
    }

}

package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

public class SurnameLengthNotValid extends ValueError {
    public SurnameLengthNotValid(){
        super("The length of the surname must be less than 20");
    }
}

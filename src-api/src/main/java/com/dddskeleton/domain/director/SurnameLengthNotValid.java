package com.dddskeleton.domain.director;

import com.dddskeleton.domain.shared.ValueError;

public class SurnameLengthNotValid extends ValueError {
    public SurnameLengthNotValid(){
        super("The length of the surname must be less than 20");
    }
}

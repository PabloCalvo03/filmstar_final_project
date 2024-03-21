package com.dddskeleton.domain.director;

import com.dddskeleton.domain.shared.ValueError;

public class NameLengthNotValid extends ValueError {

    public NameLengthNotValid(){
        super("The length of the name must be less than 20");
    }
}

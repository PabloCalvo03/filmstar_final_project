package com.filmstar.domain.director;

import com.filmstar.domain.shared.ValueError;

public class NameLengthNotValid extends ValueError {

    public NameLengthNotValid(){
        super("The length of the name must be less than 20");
    }
}

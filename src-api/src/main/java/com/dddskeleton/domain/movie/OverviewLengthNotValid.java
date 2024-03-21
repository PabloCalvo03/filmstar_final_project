package com.dddskeleton.domain.movie;

import com.dddskeleton.domain.shared.ValueError;

public class OverviewLengthNotValid extends ValueError {

    public OverviewLengthNotValid(){
        super("The length of the value must be less than 500");
    }
}

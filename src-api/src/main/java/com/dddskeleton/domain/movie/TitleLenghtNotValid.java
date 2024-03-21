package com.dddskeleton.domain.movie;

import com.dddskeleton.domain.shared.ValueError;

public class TitleLenghtNotValid extends ValueError {

    public TitleLenghtNotValid() {
        super("The length of the title must be less than 20");
    }
}

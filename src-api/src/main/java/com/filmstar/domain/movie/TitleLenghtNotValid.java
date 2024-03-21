package com.filmstar.domain.movie;

import com.filmstar.domain.shared.ValueError;

public class TitleLenghtNotValid extends ValueError {

    public TitleLenghtNotValid() {
        super("The length of the title must be less than 20");
    }
}

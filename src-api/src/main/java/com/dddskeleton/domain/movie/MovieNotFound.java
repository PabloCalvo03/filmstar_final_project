package com.dddskeleton.domain.movie;

public class MovieNotFound extends Exception {
    public MovieNotFound(String id) {
        super("Movie with id: " + id + " not found.");
    }

}

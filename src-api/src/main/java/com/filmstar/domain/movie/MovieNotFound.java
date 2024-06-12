package com.filmstar.domain.movie;

/**
 * Custom exception class for cases where a movie is not found.
 */
public class MovieNotFound extends Exception {

    /**
     * Constructs a MovieNotFound exception with a message indicating the movie ID that was not found.
     *
     * @param id The ID of the movie that was not found.
     */
    public MovieNotFound(String id) {
        super("Movie with id: " + id + " not found.");
    }
}

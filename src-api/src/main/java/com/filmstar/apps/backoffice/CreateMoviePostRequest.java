package com.filmstar.apps.backoffice;

import java.io.Serializable;

/**
 * Request class for creating a movie.
 */
public class CreateMoviePostRequest implements Serializable {

    public String id;
    public String title;
    public String overview;
    public Integer year;
    public String posterImg;
    public String directorId;

    /**
     * Default constructor.
     */
    public CreateMoviePostRequest() {
    }

    /**
     * Constructor with parameters to initialize the request.
     *
     * @param id         the ID of the movie
     * @param title      the title of the movie
     * @param overview   a brief overview of the movie
     * @param year       the release year of the movie
     * @param posterImg  the URL of the movie's poster image
     * @param directorId the ID of the director of the movie
     */
    public CreateMoviePostRequest(String id, String title, String overview, Integer year, String posterImg,
                                  String directorId) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.year = year;
        this.posterImg = posterImg;
        this.directorId = directorId;
    }
}

package com.filmstar.apps.filmstar;

import java.util.List;

/**
 * Represents the response for paginated movie data in the Filmstar application.
 */
public class PaginatedMovieResponse {
    private List<SerializedMovie> movies;
    private Integer currentPage;
    private Integer before;
    private Integer after;

    /**
     * Constructs a PaginatedMovieResponse object with the provided parameters.
     *
     * @param movies      the list of serialized movies
     * @param currentPage the current page number
     * @param before      the page number of the previous page (if exists)
     * @param after       the page number of the next page (if exists)
     */
    public PaginatedMovieResponse(List<SerializedMovie> movies, Integer currentPage, Integer before, Integer after) {
        this.movies = movies;
        this.currentPage = currentPage;
        this.before = before;
        this.after = after;
    }

    /**
     * Constructs an empty PaginatedMovieResponse object.
     */
    public PaginatedMovieResponse() {

    }

    /**
     * Retrieves the list of serialized movies.
     *
     * @return the list of serialized movies
     */
    public List<SerializedMovie> getMovies() {
        return movies;
    }

    /**
     * Sets the list of serialized movies.
     *
     * @param movies the list of serialized movies
     */
    public void setMovies(List<SerializedMovie> movies) {
        this.movies = movies;
    }

    /**
     * Retrieves the current page number.
     *
     * @return the current page number
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the current page number.
     *
     * @param currentPage the current page number
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Retrieves the page number of the previous page (if exists).
     *
     * @return the page number of the previous page (if exists)
     */
    public Integer getBefore() {
        return before;
    }

    /**
     * Sets the page number of the previous page (if exists).
     *
     * @param before the page number of the previous page (if exists)
     */
    public void setBefore(Integer before) {
        this.before = before;
    }

    /**
     * Retrieves the page number of the next page (if exists).
     *
     * @return the page number of the next page (if exists)
     */
    public Integer getAfter() {
        return after;
    }

    /**
     * Sets the page number of the next page (if exists).
     *
     * @param after the page number of the next page (if exists)
     */
    public void setAfter(Integer after) {
        this.after = after;
    }
}

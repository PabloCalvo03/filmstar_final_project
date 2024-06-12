package com.filmstar.apps.backoffice;

import com.filmstar.apps.backoffice.SerializedMovie;

import java.util.List;

/**
 * Represents a paginated response containing a list of movies.
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
     * @param before      the number of items before the current page
     * @param after       the number of items after the current page
     */
    public PaginatedMovieResponse(List<SerializedMovie> movies, Integer currentPage, Integer before, Integer after) {
        this.movies = movies;
        this.currentPage = currentPage;
        this.before = before;
        this.after = after;
    }

    /**
     * Default constructor.
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
     * @param movies the list of serialized movies to set
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
     * @param currentPage the current
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Retrieves the previous page.
     *
     * @return the previous page
     */
    public Integer getBefore() {
        return before;
    }

    /**
     * Sets the previous page.
     *
     * @param before the previous page
     */
    public void setBefore(Integer before) {
        this.before = before;
    }

    /**
     * Retrieves the next page.
     *
     * @return the next page
     */
    public Integer getAfter() {
        return after;
    }

    /**
     * Sets the next page.
     *
     * @param after the next page
     */
    public void setAfter(Integer after) {
        this.after = after;
    }
}

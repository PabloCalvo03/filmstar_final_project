package com.filmstar.apps.backoffice;

import com.filmstar.apps.backoffice.SerializedMovie;

import java.util.List;

public class PaginatedMovieResponse {
    private List<SerializedMovie> movies;
    private Integer currentPage;
    private Integer before;
    private Integer after;

    public PaginatedMovieResponse(List<SerializedMovie> movies, Integer currentPage, Integer before, Integer after) {
        this.movies = movies;
        this.currentPage = currentPage;
        this.before = before;
        this.after = after;
    }

    public PaginatedMovieResponse() {

    }

    public List<SerializedMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<SerializedMovie> movies) {
        this.movies = movies;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getBefore() {
        return before;
    }

    public void setBefore(Integer before) {
        this.before = before;
    }

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }
}

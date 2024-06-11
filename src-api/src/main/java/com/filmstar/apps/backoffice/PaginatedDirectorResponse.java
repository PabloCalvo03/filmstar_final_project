package com.filmstar.apps.backoffice;

import java.util.List;

public class PaginatedDirectorResponse {
    private List<SerializedDirector> directors;
    private Integer currentPage;
    private Integer before;
    private Integer after;

    public PaginatedDirectorResponse(List<SerializedDirector> directors, Integer currentPage, Integer before, Integer after) {
        this.directors = directors;
        this.currentPage = currentPage;
        this.before = before;
        this.after = after;
    }

    public PaginatedDirectorResponse() {

    }

    public List<SerializedDirector> getDirectors() {
        return directors;
    }

    public void setDirectors(List<SerializedDirector> directors) {
        this.directors = directors;
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

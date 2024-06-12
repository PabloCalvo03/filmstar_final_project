package com.filmstar.apps.backoffice;

import java.util.List;

/**
 * Represents a paginated response containing a list of directors.
 */
public class PaginatedDirectorResponse {

    private List<SerializedDirector> directors;
    private Integer currentPage;
    private Integer before;
    private Integer after;

    /**
     * Constructs a PaginatedDirectorResponse object with the provided parameters.
     *
     * @param directors   the list of serialized directors
     * @param currentPage the current page number
     * @param before      the number of items before the current page
     * @param after       the number of items after the current page
     */
    public PaginatedDirectorResponse(List<SerializedDirector> directors, Integer currentPage, Integer before, Integer after) {
        this.directors = directors;
        this.currentPage = currentPage;
        this.before = before;
        this.after = after;
    }

    /**
     * Default constructor.
     */
    public PaginatedDirectorResponse() {
    }

    /**
     * Retrieves the list of serialized directors.
     *
     * @return the list of serialized directors
     */
    public List<SerializedDirector> getDirectors() {
        return directors;
    }

    /**
     * Sets the list of serialized directors.
     *
     * @param directors the list of serialized directors to set
     */
    public void setDirectors(List<SerializedDirector> directors) {
        this.directors = directors;
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
     * @param currentPage the current page
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

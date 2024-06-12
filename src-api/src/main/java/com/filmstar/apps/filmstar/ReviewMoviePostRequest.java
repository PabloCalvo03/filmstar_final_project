package com.filmstar.apps.filmstar;

/**
 * Request body for adding a review to a movie in the Filmstar application.
 */
public class ReviewMoviePostRequest {

	public String comment;

	/**
	 * Default constructor.
	 */
	public ReviewMoviePostRequest() {

	}

	/**
	 * Constructs a ReviewMoviePostRequest object with the given comment.
	 *
	 * @param comment the comment for the review
	 */
	public ReviewMoviePostRequest(String comment) {
		this.comment = comment;
	}
}

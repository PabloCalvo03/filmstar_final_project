package com.filmstar.apps.filmstar;

/**
 * A class representing the request body for rating a movie in the Filmstar application.
 */
public class RatingMoviePostRequest {

	public double rating;

	/**
	 * Constructs an empty RatingMoviePostRequest object.
	 */
	public RatingMoviePostRequest() {

	}

	/**
	 * Constructs a RatingMoviePostRequest object with the provided rating value.
	 *
	 * @param rating the rating value
	 */
	public RatingMoviePostRequest(double rating) {
		this.rating = rating;
	}

}

package com.filmstar.domain.movie;

import com.filmstar.domain.user.User;

/**
 * Represents a rating given by a user to a movie.
 */
public class Rating {

	/**
	 * The unique identifier of the rating.
	 */
	private Long id;

	/**
	 * The rating value given by the user (between 0 and 10).
	 */
	private double rating;

	/**
	 * The user who gave the rating.
	 */
	private User evaluator;

	/**
	 * Default constructor.
	 */
	public Rating() {
	}

	/**
	 * Constructor that initializes the rating with a given value and evaluator.
	 *
	 * @param rating the rating value (between 0 and 10)
	 * @param evaluator the user who gave the rating
	 * @throws IllegalArgumentException if the rating value is not between 0 and 10
	 */
	public Rating(double rating, User evaluator) {
		ensureIsValidRating(rating);
		this.rating = rating;
		this.evaluator = evaluator;
	}

	/**
	 * Returns the unique identifier of the rating.
	 *
	 * @return the rating ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Returns the rating value given by the user.
	 *
	 * @return the rating value
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Returns the user who gave the rating.
	 *
	 * @return the user who gave the rating
	 */
	public User getEvaluator() {
		return evaluator;
	}

	/**
	 * Sets the unique identifier of the rating.
	 *
	 * @param id the rating ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the rating value given by the user.
	 *
	 * @param rating the rating value (between 0 and 10)
	 * @throws IllegalArgumentException if the rating value is not between 0 and 10
	 */
	public void setRating(double rating) {
		ensureIsValidRating(rating);
		this.rating = rating;
	}

	/**
	 * Sets the user who gave the rating.
	 *
	 * @param reviewer the user who gave the rating
	 */
	public void setEvaluator(User reviewer) {
		this.evaluator = reviewer;
	}

	/**
	 * Ensures that the given rating value is between 0 and 10.
	 *
	 * @param rating the rating value to check
	 * @throws IllegalArgumentException if the rating value is not between 0 and 10
	 */
	private void ensureIsValidRating(double rating) {
		if (rating < 0 || rating > 10) {
			throw new IllegalArgumentException("Rating must be between 0 and 10");
		}
	}
}
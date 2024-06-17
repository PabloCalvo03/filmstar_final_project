package com.filmstar.domain.movie;

import com.filmstar.domain.user.User;

/**
 * Represents a review given by a user to a movie.
 */
public class Review {

	/**
	 * The unique identifier of the review.
	 */
	private Long id;

	/**
	 * The comment given by the user.
	 */
	private String comment;

	/**
	 * The user who gave the review.
	 */
	private User reviewer;

	/**
	 * Default constructor.
	 */
	public Review() {
	}

	/**
	 * Constructor that initializes the review with a given comment and reviewer.
	 *
	 * @param comment the comment given by the user
	 * @param reviewer the user who gave the review
	 * @throws IllegalArgumentException if the comment is empty or exceeds 500 characters
	 */
	public Review(String comment, User reviewer) throws IllegalArgumentException {
		ensureIsNotEmpty(comment);
		ensureLengthIsValid(comment);
		this.comment = comment;
		this.reviewer = reviewer;
	}

	/**
	 * Returns the unique identifier of the review.
	 *
	 * @return the review ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Returns the comment given by the user.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Returns the user who gave the review.
	 *
	 * @return the user who gave the review
	 */
	public User getReviewer() {
		return reviewer;
	}

	/**
	 * Sets the unique identifier of the review.
	 *
	 * @param id the review ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the comment given by the user.
	 *
	 * @param comment the comment given by the user
	 * @throws IllegalArgumentException if the comment is empty or exceeds 500 characters
	 */
	public void setComment(String comment) throws IllegalArgumentException {
		ensureIsNotEmpty(comment);
		ensureLengthIsValid(comment);
		this.comment = comment;
	}

	/**
	 * Sets the user who gave the review.
	 *
	 * @param reviewer the user who gave the review
	 */
	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	/**
	 * Ensures that the given comment is not empty.
	 *
	 * @param comment the comment to check
	 * @throws IllegalArgumentException if the comment is empty
	 */
	private void ensureIsNotEmpty(String comment) throws IllegalArgumentException {
		if (comment == null || comment.trim().isEmpty()) {
			throw new IllegalArgumentException("Comment must not be empty");
		}
	}

	/**
	 * Ensures that the given comment does not exceed 500 characters.
	 *
	 * @param comment the comment to check
	 * @throws IllegalArgumentException if the comment exceeds 500 characters
	 */
	private void ensureLengthIsValid(String comment) throws IllegalArgumentException {
		if (comment.length() > 255) {
			throw new IllegalArgumentException("Comment must not exceed 200 characters");
		}
	}
}
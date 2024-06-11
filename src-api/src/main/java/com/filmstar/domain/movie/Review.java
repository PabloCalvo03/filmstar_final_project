package com.filmstar.domain.movie;

import com.filmstar.domain.user.User;

public class Review {

	private Long id;
	private String comment;
	private User reviewer;

	public Review() {
	}

	public Review(String comment, User reviewer) throws IllegalArgumentException {
		ensureIsNotEmpty(comment);
		ensureLengthIsValid(comment);
		this.comment = comment;
		this.reviewer = reviewer;
	}

	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setComment(String comment) throws IllegalArgumentException {
		ensureIsNotEmpty(comment);
		ensureLengthIsValid(comment);
		this.comment = comment;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	private void ensureIsNotEmpty(String comment) throws IllegalArgumentException {
		if (comment == null || comment.trim().isEmpty()) {
			throw new IllegalArgumentException("Comment must not be empty");
		}
	}

	private void ensureLengthIsValid(String comment) throws IllegalArgumentException {
		if (comment.length() > 500) {
			throw new IllegalArgumentException("Comment must not exceed 500 characters");
		}
	}
}

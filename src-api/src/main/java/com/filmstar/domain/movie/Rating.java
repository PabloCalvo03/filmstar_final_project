package com.filmstar.domain.movie;

import com.filmstar.domain.user.User;

public class Rating {

	private Long id;
	private double rating;
	private User evaluator;

	public Rating() {

	}

	public Rating(double rating, User evaluator) {
		this.rating = rating;
		this.evaluator = evaluator;
	}

	public Long getId() {
		return id;
	}

	public double getRating() {
		return rating;
	}

	public User getEvaluator() {
		return evaluator;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void setEvaluator(User reviewer) {
		this.evaluator = reviewer;
	}

}

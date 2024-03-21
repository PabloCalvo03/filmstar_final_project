package com.filmstar.domain.movie;

import com.filmstar.domain.director.Director;

import java.util.HashSet;
import java.util.Set;

public class Movie {
	
	private MovieId id;
	private Title title;
	private Overview overview;
	private Director director;
	private Set<Review> reviews;
	private Status status;

	public Movie() {
		
	}
	
	private Movie(MovieId id, Title title, Overview overview, Director director) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.director = director;
		this.status = Status.AVAILABLE;
		this.reviews = new HashSet<Review>();
	}
	
	public static Movie register(MovieId id, Title title, Overview overview, Director director) {
		return new Movie(id, title, overview, director);
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}


	public MovieId id() {
		return id;
	}


	public Title title() {
		return title;
	}


	public Overview overview() {
		return overview;
	}
	
	public Director director() {
		return director;
	}
	
	public Set<Review> getReviews() {
		return reviews;
	}

	public Status status() {
		return status;
	}


	
	
}

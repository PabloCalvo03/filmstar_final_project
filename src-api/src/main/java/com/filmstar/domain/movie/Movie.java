package com.filmstar.domain.movie;

import com.filmstar.domain.director.Director;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	
	private MovieId id;
	private Title title;
	private Overview overview;

	private PosterImg posterImg;
	private Director director;
	private List<Review> reviews;
	private Status status;

	public Movie() {
		this.reviews = new ArrayList<Review>();
	}
	
	private Movie(MovieId id, Title title, Overview overview, PosterImg posterImg, Director director) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.director = director;
		this.status = Status.AVAILABLE;
		this.reviews = new ArrayList<Review>();
	}
	
	public static Movie register(MovieId id, Title title, Overview overview, PosterImg posterImg, Director director) {
		return new Movie(id, title, overview, posterImg, director);
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
	
	public List<Review> reviews() {
		return reviews;
	}

	public Status status() {
		return status;
	}

	public PosterImg posterImg() {
		return posterImg;
	}

}

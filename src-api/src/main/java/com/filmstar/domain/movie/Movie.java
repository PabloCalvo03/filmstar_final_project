package com.filmstar.domain.movie;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Movie {
	
	private MovieId id;
	private Title title;
	private Overview overview;
	private Year year;
	private PosterImg posterImg;
	private Director director;
	private List<Review> reviews;
	private List<Rating> ratings;
	private Status status;

	public Movie() {
		this.reviews = new ArrayList<Review>();
	}
	
	private Movie(MovieId id, Title title, Overview overview, Year year, PosterImg posterImg, Director director) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.posterImg = posterImg;
		this.director = director;
		this.year = year;
		this.status = Status.AVAILABLE;
		this.reviews = new ArrayList<Review>();
		this.ratings = new ArrayList<Rating>();
	}
	
	public static Movie register(MovieId id, Title title, Overview overview, PosterImg posterImg,
								 Year year, Director director) throws IllegalArgumentException {
		return new Movie(id, title, overview, year, posterImg, director);
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void addRating(Rating rating){
		this.ratings.add(rating);
	}


	public MovieId id() {
		return id;
	}


	public Title title() {
		return title;
	}

	public Year year(){
		return year;
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
	public List<Rating> ratings() {
		return ratings;
	}

	public Status status() {
		return status;
	}

	public PosterImg posterImg() {
		return posterImg;
	}

	public double calculateAverageRating() {
		if (ratings.isEmpty()) {
			return 0.0;
		}
		double sum = 0.0;
		for (Rating rating : ratings) {
			sum += rating.getRating();
		}
		return sum / ratings.size();
	}

	public Optional<Rating> ratingFromUser(User user) {
		return ratings.stream()
				.filter(rating -> rating.getEvaluator().email().value().equals(user.email().value()))
				.findFirst();
	}

}

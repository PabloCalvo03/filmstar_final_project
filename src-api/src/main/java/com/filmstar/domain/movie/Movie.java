package com.filmstar.domain.movie;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.shared.Status;
import com.filmstar.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents a movie entity.
 */
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

	/**
	 * Default constructor.
	 */
	public Movie() {
		this.reviews = new ArrayList<>();
	}

	/**
	 * Parameterized constructor for creating a movie instance.
	 */
	private Movie(MovieId id, Title title, Overview overview, Year year, PosterImg posterImg, Director director) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.posterImg = posterImg;
		this.director = director;
		this.year = year;
		this.status = Status.AVAILABLE;
		this.reviews = new ArrayList<>();
		this.ratings = new ArrayList<>();
	}

	/**
	 * Factory method to register a new movie.
	 *
	 * @param id        The ID of the movie.
	 * @param title     The title of the movie.
	 * @param overview  The overview of the movie.
	 * @param posterImg The poster image of the movie.
	 * @param year      The release year of the movie.
	 * @param director  The director of the movie.
	 * @return A new movie instance.
	 * @throws IllegalArgumentException If any argument is invalid.
	 */
	public static Movie register(MovieId id, Title title, Overview overview, PosterImg posterImg,
								 Year year, Director director) throws IllegalArgumentException {
		return new Movie(id, title, overview, year, posterImg, director);
	}

	/**
	 * Adds a review to the movie.
	 *
	 * @param review The review to add.
	 */
	public void addReview(Review review) {
		this.reviews.add(review);
	}

	/**
	 * Adds a rating to the movie.
	 *
	 * @param rating The rating to add.
	 */
	public void addRating(Rating rating) {
		this.ratings.add(rating);
	}

	public MovieId id() {
		return id;
	}

	public void id(MovieId id) {
		this.id = id;
	}

	public Title title() {
		return title;
	}

	public void title(Title title) {
		this.title = title;
	}

	public Overview overview() {
		return overview;
	}

	public void overview(Overview overview) {
		this.overview = overview;
	}

	public Year year() {
		return year;
	}

	public void year(Year year) {
		this.year = year;
	}

	public PosterImg posterImg() {
		return posterImg;
	}

	public void posterImg(PosterImg posterImg) {
		this.posterImg = posterImg;
	}

	public Director director() {
		return director;
	}

	public void director(Director director) {
		this.director = director;
	}

	public List<Review> reviews() {
		return reviews;
	}

	public void reviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Rating> ratings() {
		return ratings;
	}

	public void ratings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Status status() {
		return status;
	}

	public void status(Status status) {
		this.status = status;
	}

	/**
	 * Calculates the average rating of the movie.
	 *
	 * @return The average rating.
	 */
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

	/**
	 * Retrieves the rating given by a specific user.
	 *
	 * @param user The user.
	 * @return An optional containing the rating given by the user, if available.
	 */
	public Optional<Rating> ratingFromUser(User user) {
		return ratings.stream()
				.filter(rating -> rating.getEvaluator().email().value().equals(user.email().value()))
				.findFirst();
	}
}

package com.filmstar.apps.filmstar;

import com.filmstar.apps.backoffice.SerializedDirector;
import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a serialized movie in the Filmstar application.
 */
public class SerializedMovie {

	public String id;
	public String title;
	public String overview;
	public Integer year;
	public String posterImg;
	public List<Review> reviews;
	public double averageRating;
	public SerializedDirector director;

	/**
	 * Constructs a SerializedMovie object with the provided parameters.
	 *
	 * @param id             the ID of the movie
	 * @param title          the title of the movie
	 * @param overview       the overview of the movie
	 * @param reviews        the list of reviews for the movie
	 * @param averageRating  the average rating of the movie
	 * @param year           the release year of the movie
	 * @param posterImg      the URL of the movie poster image
	 * @param movieDirector  the serialized director of the movie
	 */
	public SerializedMovie(String id, String title, String overview, List<Review> reviews, double averageRating,
						   Integer year, String posterImg, SerializedDirector movieDirector) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.year = year;
		this.posterImg = posterImg;
		this.reviews = reviews;
		this.averageRating = averageRating;
		this.director = movieDirector;
	}

	/**
	 * Converts a Movie object to a SerializedMovie object.
	 *
	 * @param movie the movie to serialize
	 * @return a SerializedMovie object representing the provided movie
	 */
	public static SerializedMovie from(Movie movie) {
		List<Review> reviews = movie.reviews() != null ? movie.reviews() : new ArrayList<>();
		return new SerializedMovie(
				movie.id().value(),
				movie.title().value(),
				movie.overview().value(),
				reviews,
				movie.calculateAverageRating(),
				movie.year().value(),
				movie.posterImg().value(),
				SerializedDirector.from(movie.director())
		);
	}
}

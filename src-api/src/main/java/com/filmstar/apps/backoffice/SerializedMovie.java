package com.filmstar.apps.backoffice;

import com.filmstar.domain.movie.Movie;

/**
 * A class for serializing Movie objects into JSON format.
 */
public class SerializedMovie {

	public String id;
	public String title;
	public String overview;
	public String status;
	public SerializedDirector director;

	/**
	 * Constructs a SerializedMovie object with the provided parameters.
	 *
	 * @param id         the ID of the movie
	 * @param title      the title of the movie
	 * @param overview   the overview of the movie
	 * @param status     the status of the movie
	 * @param movieDirector the director of the movie
	 */
	public SerializedMovie(String id, String title, String overview, String status, SerializedDirector movieDirector) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.status = status;
		this.director = movieDirector;
	}

	/**
	 * Creates a SerializedMovie object from a Movie object.
	 *
	 * @param movie the Movie object to serialize
	 * @return a SerializedMovie object
	 */
	public static SerializedMovie from(Movie movie) {
		return new SerializedMovie(
				movie.id().value(),
				movie.title().value(),
				movie.overview().value(),
				movie.status().name(),
				SerializedDirector.from(movie.director())
		);
	}
}

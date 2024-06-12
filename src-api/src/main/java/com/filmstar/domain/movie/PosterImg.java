package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

/**
 * Represents a poster image for a movie.
 *
 * @see Serializable
 */
public class PosterImg implements Serializable {

	/**
	 * The value of the poster image URL.
	 */
	private String value;

	/**
	 * Default constructor.
	 */
	public PosterImg() {
	}

	/**
	 * Constructor that initializes the poster image with a given value.
	 *
	 * @param value the URL of the poster image
	 * @throws ValueError if the value is null or empty, or if it's not a valid URL from TMDB
	 */
	public PosterImg(String value) throws ValueError {
		ensureIsNotEmpty(value);
		ensureIsMovieFromTMDB(value);
		this.value = value;
	}

	/**
	 * Returns the value of the poster image URL.
	 *
	 * @return the URL of the poster image
	 */
	public String value() {
		return value;
	}

	/**
	 * Ensures that the given value is not null or empty.
	 *
	 * @param value the value to check
	 * @throws ValueError if the value is null or empty
	 */
	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.isBlank()) {
			throw new ValueError(getClass().getSimpleName() + " cannot be null or empty");
		}
	}

	/**
	 * Ensures that the given value is a valid URL from TMDB.
	 *
	 * @param value the value to check
	 * @throws ValueError if the value is not a valid URL from TMDB
	 */
	private void ensureIsMovieFromTMDB(String value) throws ValueError {
		if (!value.matches("^https://image.tmdb.org/t/p/w\\d+/.+\\.(jpg|jpeg|png)$") &&
				!value.matches("^https://www.themoviedb.org/t/p/w\\d+/.+\\.(jpg|jpeg|png)$")) {
			throw new ValueError("Poster Image URL must be a valid URL from TMDB");
		}
	}
}
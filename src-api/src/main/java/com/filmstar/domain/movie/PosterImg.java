package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

public class PosterImg implements Serializable {

	private String value;

	public PosterImg() {
	}

	public PosterImg(String value) throws ValueError {
		ensureIsNotEmpty(value);
		ensureIsMovieFromTMDB(value);
		this.value = value;
	}

	public String value() {
		return value;
	}

	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.isBlank()) {
			throw new ValueError(getClass().getSimpleName() + " cannot be null or empty");
		}
	}

	private void ensureIsMovieFromTMDB(String value) throws ValueError {
		if (!value.matches("^https://image.tmdb.org/t/p/w\\d+/.+\\.(jpg|jpeg|png)$") &&
				!value.matches("^https://www.themoviedb.org/t/p/w\\d+/.+\\.(jpg|jpeg|png)$")) {
			throw new ValueError("Poster Image URL must be a valid URL from TMDB");
		}
	}
}

package com.filmstar.domain.movie;

import java.io.Serializable;

import com.filmstar.domain.shared.ValueError;

public class PosterImg implements Serializable{

	private String value;

	public PosterImg() {
    }

	public PosterImg(String value) throws ValueError {
		ensureIsNotEmpty(value);
		this.value = value;
	}

	public String value() {
		return value;
	}

	private void ensureIsNotEmpty(String value) throws ValueError {
		if (value == null || value.length() == 0 || value == "") {
			throw new ValueError(getClass().getSimpleName() + " cannot be null");
		}
	}
}

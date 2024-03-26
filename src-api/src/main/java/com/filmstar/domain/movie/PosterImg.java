package com.filmstar.domain.movie;

import java.io.Serializable;

public class PosterImg implements Serializable{

	private String value;

	public PosterImg() {
    }

	public PosterImg(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}

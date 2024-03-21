package com.filmstar.domain.movie;

import java.io.Serializable;

public class MovieId implements Serializable{
	
	private String value;
	
	public MovieId() {
    }
	
	public MovieId(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}

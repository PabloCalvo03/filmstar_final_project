package com.filmstar.domain.director;

public class DirectorNotFound extends Exception {

	public DirectorNotFound(String id) {
		super("Director with id: " + id + " not found.");
	}

}

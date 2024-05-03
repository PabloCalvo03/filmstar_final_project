package com.filmstar.domain.movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
	
	void save(Movie movie);
	
	List<Movie> findAll();
	
	List<Movie> findAllAvailable();
	
	Optional<Movie> findById(MovieId id);

	Movie findByIdOrFail(MovieId id) throws MovieNotFound;

	List<Movie> findMoviesByTitleStartingWith(Title title);
}

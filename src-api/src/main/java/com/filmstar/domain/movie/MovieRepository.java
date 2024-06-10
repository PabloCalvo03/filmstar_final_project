package com.filmstar.domain.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
	
	void save(Movie movie);
	
	Page<Movie> findAll(Pageable pageable);
	
	Page<Movie> findAllAvailable(Pageable pageable);
	
	Optional<Movie> findById(MovieId id);

	Movie findByIdOrFail(MovieId id) throws MovieNotFound;

	Page<Movie> findMoviesByTitleContainingAndAvailable(Title title, PageRequest pageRequest);

    void deactivateMovie(MovieId movieId) throws Exception;

	void activateMovie(MovieId movieId) throws Exception;
}
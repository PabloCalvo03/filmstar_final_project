package com.filmstar.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import com.filmstar.domain.movie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * JPA-based implementation of the MovieRepository interface.
 */
@Service
@Primary
public class JpaMovieRepository implements MovieRepository {

	/**
	 * Autowired instance of the JpaBridgeMovieRepository.
	 */
	@Autowired
	private JpaBridgeMovieRepository movieRepository;

	/**
	 * Saves a movie.
	 *
	 * @param movie the movie to save
	 */
	@Override
	public void save(Movie movie) {
		this.movieRepository.save(movie);
	}

	/**
	 * Finds all movies with pagination.
	 *
	 * @param pageable pagination information
	 * @return a page of movies
	 */
	@Override
	public Page<Movie> findAll(Pageable pageable) {
		return this.movieRepository.findAll(pageable);
	}

	/**
	 * Finds all available movies with pagination.
	 *
	 * @param pageable pagination information
	 * @return a page of available movies
	 */
	@Override
	public Page<Movie> findAllAvailable(Pageable pageable) {
		return movieRepository.findAllAvailable(pageable);
	}

	/**
	 * Finds a movie by its ID.
	 *
	 * @param id the ID of the movie to find
	 * @return an optional containing the movie if found, or an empty optional if not found
	 */
	@Override
	public Optional<Movie> findById(MovieId id) {
		return movieRepository.findById(id);
	}

	/**
	 * Finds a movie by its ID, or throws a MovieNotFound exception if not found.
	 *
	 * @param id the ID of the movie to find
	 * @return the movie if found
	 * @throws MovieNotFound if the movie is not found
	 */
	@Override
	public Movie findByIdOrFail(MovieId id) throws MovieNotFound {
		return this.findById(id).orElseThrow(() -> new MovieNotFound(id.value()));
	}

	/**
	 * Finds movies by title containing a certain string and available.
	 *
	 * @param title the title to search for
	 * @param pageRequest pagination information
	 * @return a page of movies
	 */
	@Override
	public Page<Movie> findMoviesByTitleContainingAndAvailable(Title title, PageRequest pageRequest) {
		return movieRepository.findMoviesByTitleContainingAndAvailable(title.value(), pageRequest);
	}

	/**
	 * Deactivates a movie.
	 *
	 * @param movieId the ID of the movie to deactivate
	 */
	@Override
	public void deactivateMovie(MovieId movieId) {
		movieRepository.deactivateMovie(movieId);
	}

	/**
	 * Activates a movie.
	 *
	 * @param movieId the ID of the movie to activate
	 */
	@Override
	public void activateMovie(MovieId movieId) {
		movieRepository.activateMovie(movieId);
	}
}
package com.filmstar.domain.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Repository interface for managing movies.
 */
public interface MovieRepository {

	/**
	 * Saves a movie.
	 *
	 * @param movie The movie to save.
	 */
	void save(Movie movie);

	/**
	 * Retrieves all movies.
	 *
	 * @param pageable The pageable object for pagination.
	 * @return A page containing all movies.
	 */
	Page<Movie> findAll(Pageable pageable);

	/**
	 * Retrieves all available movies.
	 *
	 * @param pageable The pageable object for pagination.
	 * @return A page containing all available movies.
	 */
	Page<Movie> findAllAvailable(Pageable pageable);

	/**
	 * Retrieves a movie by its ID.
	 *
	 * @param id The ID of the movie to retrieve.
	 * @return An Optional containing the movie if found, or empty otherwise.
	 */
	Optional<Movie> findById(MovieId id);

	/**
	 * Retrieves a movie by its ID, throwing an exception if not found.
	 *
	 * @param id The ID of the movie to retrieve.
	 * @return The movie with the specified ID.
	 * @throws MovieNotFound If the movie with the specified ID is not found.
	 */
	Movie findByIdOrFail(MovieId id) throws MovieNotFound;

	/**
	 * Retrieves movies by title containing and available.
	 *
	 * @param title The title to search for.
	 * @param pageRequest The page request object for pagination.
	 * @return A page containing movies with titles containing the specified title and available status.
	 */
	Page<Movie> findMoviesByTitleContainingAndAvailable(Title title, PageRequest pageRequest);

	/**
	 * Deactivates a movie.
	 *
	 * @param movieId The ID of the movie to deactivate.
	 * @throws Exception If an error occurs while deactivating the movie.
	 */
	void deactivateMovie(MovieId movieId) throws Exception;

	/**
	 * Activates a movie.
	 *
	 * @param movieId The ID of the movie to activate.
	 * @throws Exception If an error occurs while activating the movie.
	 */
	void activateMovie(MovieId movieId) throws Exception;
}

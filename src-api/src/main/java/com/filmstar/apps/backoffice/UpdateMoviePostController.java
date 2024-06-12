package com.filmstar.apps.backoffice;

import com.filmstar.application.AddMovieUseCase;
import com.filmstar.domain.director.DirectorNotFound;
import com.filmstar.domain.director.DirectorRepository;
import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.shared.ValueError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST controller for creating movies.
 */
@RestController
@RequestMapping("/api/backoffice/movies")
@CrossOrigin("*")
public class UpdateMoviePostController {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private DirectorRepository directorRepository;

	/**
	 * Updates a movie with the provided information.
	 *
	 * @param movieRequest the request containing the movie's data
	 * @return a ResponseEntity with the created movie and HTTP status 201 if the creation is successful,
	 *         or an error message and HTTP status 400 if there is a validation error or if the director is not found
	 */
	@PutMapping
	public ResponseEntity<?> execute(@RequestBody CreateMoviePostRequest movieRequest) {
		try {
			Movie movie = new AddMovieUseCase(movieRepository, directorRepository).execute(movieRequest.id,
					movieRequest.title, movieRequest.overview, movieRequest.year, movieRequest.posterImg,
					movieRequest.directorId);
			return new ResponseEntity<>(SerializedMovie.from(movie), HttpStatus.CREATED);
		} catch (DirectorNotFound | ValueError e) {
			return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
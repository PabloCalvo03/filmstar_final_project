package com.filmstar.apps.filmstar;

import com.filmstar.domain.movie.*;
import com.filmstar.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for adding a review to a movie in the Filmstar application.
 */
@RestController
@RequestMapping(value="/api/filmstar/movies/{id}/reviews")
@CrossOrigin("*")
public class ReviewMoviePostController {

	@Autowired
	private MovieRepository movieRepository;

	/**
	 * Adds a review to the specified movie.
	 *
	 * @param reviewer       the authenticated user submitting the review
	 * @param id             the ID of the movie to review
	 * @param reviewRequest  the request body containing the review details
	 * @return a ResponseEntity with the updated movie details and HTTP status 202
	 * @throws Exception if the movie with the specified ID is not found
	 */
	@PostMapping
	public ResponseEntity<SerializedMovie> execute(@AuthenticationPrincipal User reviewer, @PathVariable String id, @RequestBody ReviewMoviePostRequest reviewRequest) throws Exception {
		Movie movie = movieRepository.findByIdOrFail(new MovieId(id));
		movie.addReview(new Review(reviewRequest.comment, reviewer));
		movieRepository.save(movie);
		return new ResponseEntity<>(SerializedMovie.from(movie), HttpStatus.ACCEPTED);
	}

}

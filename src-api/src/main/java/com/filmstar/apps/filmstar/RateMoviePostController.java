package com.filmstar.apps.filmstar;

import com.filmstar.domain.movie.*;
import com.filmstar.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST controller for rating movies in the Filmstar application.
 */
@RestController
@RequestMapping(value="/api/filmstar/movies/{id}/ratings")
@CrossOrigin("*")
public class RateMoviePostController {

	@Autowired
	private MovieRepository movieRepository;

	/**
	 * Rates a movie with the provided rating value.
	 *
	 * @param evaluator     the authenticated user rating the movie
	 * @param id            the ID of the movie to rate
	 * @param ratingRequest the request body containing the rating value
	 * @return a ResponseEntity with the serialized movie and HTTP status 202 if the rating is successful
	 * @throws Exception if the movie with the given ID is not found
	 */
	@PostMapping
	public ResponseEntity<SerializedMovie> execute(@AuthenticationPrincipal User evaluator, @PathVariable String id, @RequestBody RatingMoviePostRequest ratingRequest) throws Exception {
		Movie movie = movieRepository.findByIdOrFail(new MovieId(id));

		Optional<Rating> existingRating = movie.ratingFromUser(evaluator);
		if (existingRating.isPresent()) {
			existingRating.get().setRating(ratingRequest.rating);
		} else {
			// If the user has not rated, add a new rating
			movie.addRating(new Rating(ratingRequest.rating, evaluator));
		}

		movieRepository.save(movie);
		return new ResponseEntity<>(SerializedMovie.from(movie), HttpStatus.ACCEPTED);
	}

}

package com.filmstar.apps.filmstar;

import com.filmstar.domain.movie.*;
import com.filmstar.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/filmstar/movies/{id}/ratings")
@CrossOrigin("*")
public class RateMoviePostController {
	
	@Autowired
	private MovieRepository movieRepository;

	@PostMapping
	public ResponseEntity<SerializedMovie> execute(@AuthenticationPrincipal User evaluator, @PathVariable String id, @RequestBody RatingMoviePostRequest ratingRequest) throws Exception{
		Movie movie = movieRepository.findByIdOrFail(new MovieId(id));
		movie.addRating(new Rating(ratingRequest.rating, evaluator));
		movieRepository.save(movie);
		return new ResponseEntity<>(SerializedMovie.from(movie), HttpStatus.ACCEPTED);
	}
	
}

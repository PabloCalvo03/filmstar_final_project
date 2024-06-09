package com.filmstar.apps.filmstar;

import com.filmstar.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.movie.Review;

@RestController
@RequestMapping(value="/api/filmstar/movies/{id}/reviews")
@CrossOrigin("*")
public class ReviewMoviePostController {
	
	@Autowired
	private MovieRepository movieRepository;

	@PostMapping
	public ResponseEntity<SerializedMovie> execute(@AuthenticationPrincipal User reviewer, @PathVariable String id, @RequestBody ReviewMoviePostRequest reviewRequest) throws Exception{
		Movie movie = movieRepository.findByIdOrFail(new MovieId(id));
		movie.addReview(new Review(reviewRequest.comment, reviewer));
		movieRepository.save(movie);
		return new ResponseEntity<>(SerializedMovie.from(movie), HttpStatus.ACCEPTED);
	}
	
}

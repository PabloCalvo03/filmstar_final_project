package com.filmstar.apps.movierecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.movie.Review;

@RestController
@RequestMapping(method=RequestMethod.POST, value="/api/movierecords/movies/{id}/reviews")
public class ReviewMoviePostController {
	
	@Autowired
	private MovieRepository movieRepository;

	@PostMapping
	public ResponseEntity<Movie> execute(@PathVariable String id, @RequestBody String comment) throws Exception{
		Movie movie = movieRepository.findByIdOrFail(new MovieId(id));
		movie.addReview(new Review(comment));
		return new ResponseEntity<>(movie, HttpStatus.ACCEPTED);
	}
	
}

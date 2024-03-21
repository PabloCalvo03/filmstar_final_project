package com.dddskeleton.apps.backoffice;

import java.util.Map;

import com.dddskeleton.domain.shared.ValueError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dddskeleton.DddSkeletonApplication;
import com.dddskeleton.application.AddMovieUseCase;
import com.dddskeleton.domain.director.DirectorNotFound;
import com.dddskeleton.domain.director.DirectorRepository;
import com.dddskeleton.domain.movie.Movie;
import com.dddskeleton.domain.movie.MovieRepository;

@RestController
@RequestMapping("/api/backoffice/movies")
public class CreateMoviePostController {
	
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private DirectorRepository directorRepository;
	
	@PostMapping
	public ResponseEntity<?> execute(@RequestBody CreateMoviePostRequest movieRequest) {
		try {
			Movie movie = new AddMovieUseCase(movieRepository, directorRepository).execute(movieRequest.id,
					movieRequest.title, movieRequest.description, movieRequest.directorId);
			return new ResponseEntity<>(SerializedMovie.from(movie), HttpStatus.CREATED);
		} catch (DirectorNotFound | ValueError e) {
			return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.BAD_REQUEST);
		}

	}

}












// 1. Crear agregado director

// 2. Request MoviePostRequest director_id

// 3. Post controller director

// 4. MovieReview
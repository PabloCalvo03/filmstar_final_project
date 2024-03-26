package com.filmstar.apps.backoffice;

import java.util.Map;

import com.filmstar.domain.shared.ValueError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmstar.application.AddMovieUseCase;
import com.filmstar.domain.director.DirectorNotFound;
import com.filmstar.domain.director.DirectorRepository;
import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieRepository;

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
					movieRequest.title, movieRequest.description, movieRequest.posterImg, movieRequest.directorId);
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
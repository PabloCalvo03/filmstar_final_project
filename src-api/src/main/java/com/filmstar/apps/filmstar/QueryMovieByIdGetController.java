package com.filmstar.apps.filmstar;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.shared.ValueError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for retrieving movie details by ID.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/movies/{id}")
@Qualifier("filmstar")
public class QueryMovieByIdGetController {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Retrieves details of a movie by its ID.
     *
     * @param id the ID of the movie to retrieve
     * @return a ResponseEntity with the serialized movie details and HTTP status 200 if successful
     * @throws ValueError if the provided movie ID is invalid
     */
    @GetMapping
    public ResponseEntity<?> execute(@PathVariable("id") String id) throws ValueError {
        return new ResponseEntity<>(SerializedMovie.from(movieRepository.findById(new MovieId(id)).get()),
                HttpStatus.OK);
    }
}

package com.filmstar.apps.backoffice;

import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for activating movies.
 */
@RestController
@RequestMapping("/api/backoffice/movies/{movieId}/activate")
@CrossOrigin("*")
public class ActivateMoviePostController {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Activates a movie with the given movie ID.
     *
     * @param movieId the ID of the movie to activate
     * @return a ResponseEntity with a success message and HTTP status 200 if the activation is successful,
     *         or an error message and HTTP status 500 if the activation fails
     */
    @PostMapping
    public ResponseEntity<String> activateMovie(@PathVariable String movieId) {
        try {
            movieRepository.activateMovie(new MovieId(movieId));
            return new ResponseEntity<>("Movie activated successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Failed to activate movie", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

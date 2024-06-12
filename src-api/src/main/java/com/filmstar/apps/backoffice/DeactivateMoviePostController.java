package com.filmstar.apps.backoffice;

import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for deactivating movies in the back office system.
 */
@RestController
@RequestMapping("/api/backoffice/movies/{movieId}/deactivate")
@CrossOrigin("*")
public class DeactivateMoviePostController {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Deactivates a movie with the given movie ID.
     *
     * @param movieId the ID of the movie to deactivate
     * @return a ResponseEntity with a success message and HTTP status 200 if the deactivation is successful,
     *         or an error message and HTTP status 500 if the deactivation fails
     */
    @PostMapping
    public ResponseEntity<String> deactivateMovie(@PathVariable String movieId) {
        try {
            movieRepository.deactivateMovie(new MovieId(movieId));
            return new ResponseEntity<>("Movie deactivated successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Failed to deactivate movie", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

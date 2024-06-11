package com.filmstar.apps.backoffice;
import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/backoffice/movies/{movieId}/deactivate")
@CrossOrigin("*")
public class DeactivateMoviePostController {

    @Autowired
    private MovieRepository movieRepository;

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

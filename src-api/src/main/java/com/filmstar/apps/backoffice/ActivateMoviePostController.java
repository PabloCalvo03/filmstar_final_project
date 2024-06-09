package com.filmstar.apps.backoffice;
import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/backoffice/movies/activate/{movieId}")
@CrossOrigin("*")
public class ActivateMoviePostController {

    @Autowired
    private MovieRepository movieRepository;

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

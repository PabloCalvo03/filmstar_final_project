package com.filmstar.apps.filmstar;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.shared.ValueError;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/movies/{id}")
@Qualifier("movierecords")
public class QueryMovieByIdGetController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<?> execute(@PathVariable("id") String id) throws ValueError{
        return new ResponseEntity<>(SerializedMovie.from(movieRepository.findById(new MovieId(id)).get()),
                HttpStatus.OK);
    }

}
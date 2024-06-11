package com.filmstar.apps.backoffice;

import com.filmstar.apps.filmstar.SerializedMovie;
import com.filmstar.domain.director.DirectorId;
import com.filmstar.domain.director.DirectorRepository;
import com.filmstar.domain.movie.MovieId;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.shared.ValueError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/directors/{id}")
@Qualifier("backoffice")
public class QueryDirectorByIdGetController {

    @Autowired
    private DirectorRepository movieRepository;

    @GetMapping
    public ResponseEntity<?> execute(@PathVariable("id") String id) throws ValueError{
        return new ResponseEntity<>(SerializedDirector.from(movieRepository.findById(new DirectorId(id)).get()),
                HttpStatus.OK);
    }


}
package com.filmstar.apps.backoffice;

import com.filmstar.application.AddDirectorUseCase;
import com.filmstar.domain.director.Director;
import com.filmstar.domain.director.DirectorRepository;
import com.filmstar.domain.shared.ValueError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST controller for creating directors.
 */
@RestController
@RequestMapping("/api/backoffice/directors")
@CrossOrigin("*")
public class UpdateDirectorPostController {

    @Autowired
    private DirectorRepository directorRepository;

    /**
     * Updates a director with the provided information.
     *
     * @param movieDirectorRequest the request containing the director's data
     * @return a ResponseEntity with the created director and HTTP status 201 if the update is successful,
     *         or an error message and HTTP status 400 if there is a validation error
     */
    @PutMapping
    public ResponseEntity<?> execute(@RequestBody CreateDirectorPostRequest movieDirectorRequest) {
        try {
            Director director = new AddDirectorUseCase(directorRepository).execute(movieDirectorRequest.id,
                    movieDirectorRequest.name, movieDirectorRequest.surname);
            return new ResponseEntity<>(SerializedDirector.from(director), HttpStatus.CREATED);
        } catch (ValueError e) {
            return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}

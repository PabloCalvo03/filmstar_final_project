package com.filmstar.apps.backoffice;

import com.filmstar.application.AddDirectorUseCase;
import com.filmstar.domain.director.*;
import com.filmstar.domain.shared.ValueError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/backoffice/directors")
public class CreateDirectorPostController {

    @Autowired
    private DirectorRepository directorRepository;

    @PostMapping
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

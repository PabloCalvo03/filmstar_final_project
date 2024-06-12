package com.filmstar.apps.backoffice;

import com.filmstar.domain.director.DirectorId;
import com.filmstar.domain.director.DirectorRepository;
import com.filmstar.domain.shared.ValueError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for querying directors by ID.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/directors/{id}")
@Qualifier("backoffice")
public class QueryDirectorByIdGetController {

    @Autowired
    private DirectorRepository directorRepository;

    /**
     * Retrieves a director by ID.
     *
     * @param id the ID of the director to retrieve
     * @return a ResponseEntity with the serialized director and HTTP status 200 if the retrieval is successful,
     *         or an error message and HTTP status 500 if the retrieval fails
     * @throws ValueError if the provided ID is invalid
     */
    @GetMapping
    public ResponseEntity<?> execute(@PathVariable("id") String id) throws ValueError {
        return new ResponseEntity<>(SerializedDirector.from(directorRepository.findById(new DirectorId(id)).get()),
                HttpStatus.OK);
    }
}

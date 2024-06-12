package com.filmstar.apps.backoffice;

import com.filmstar.domain.director.DirectorId;
import com.filmstar.domain.director.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for deactivating directors.
 */
@RestController
@RequestMapping("/api/backoffice/directors/{directorId}/deactivate")
@CrossOrigin("*")
public class DeactivateDirectorPostController {

    @Autowired
    private DirectorRepository directorRepository;

    /**
     * Deactivates a director with the given director ID.
     *
     * @param directorId the ID of the director to deactivate
     * @return a ResponseEntity with a success message and HTTP status 200 if the deactivation is successful,
     *         or an error message and HTTP status 500 if the deactivation fails
     */
    @PostMapping
    public ResponseEntity<String> deactivateDirector(@PathVariable String directorId) {
        try {
            directorRepository.deactivateDirector(new DirectorId(directorId));
            return new ResponseEntity<>("Director deactivated successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Failed to deactivate director", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

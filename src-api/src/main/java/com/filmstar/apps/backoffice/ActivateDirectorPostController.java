package com.filmstar.apps.backoffice;

import com.filmstar.domain.director.DirectorId;
import com.filmstar.domain.director.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/backoffice/directors/{directorId}/activate")
@CrossOrigin("*")
public class ActivateDirectorPostController {

    @Autowired
    private DirectorRepository directorRepository;

    @PostMapping
    public ResponseEntity<String> activateDirector(@PathVariable String directorId) {
        try {
            directorRepository.activateDirector(new DirectorId(directorId));
            return new ResponseEntity<>("Director activated successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Failed to activate director", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

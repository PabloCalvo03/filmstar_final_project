package com.filmstar.application;

import com.filmstar.domain.director.*;
import com.filmstar.domain.shared.ValueError;

/**
 * Use case for adding a new director.
 */
public class AddDirectorUseCase {

    /**
     * The repository for accessing and storing director data.
     */
    private final DirectorRepository directorRepository;

    /**
     * Constructor for the AddDirectorUseCase.
     *
     * @param directorRepository the director repository
     */
    public AddDirectorUseCase(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    /**
     * Executes the use case for adding a new director.
     *
     * @param id the unique identifier for the director
     * @param name the director's name
     * @param surname the director's surname
     * @return the newly created director
     * @throws ValueError if the input data is invalid
     */
    public Director execute(String id, String name, String surname) throws ValueError {
        Director director = new Director(new DirectorId(id), new Name(name),
                new Surname(surname));
        directorRepository.save(director);
        return director;
    }

}
package com.filmstar.application;

import com.filmstar.domain.director.*;
import com.filmstar.domain.shared.ValueError;

public class AddDirectorUseCase {

    final DirectorRepository directorRepository;

    public AddDirectorUseCase(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    public Director execute(String id, String name, String surname) throws ValueError {
        Director director = new Director(new DirectorId(id), new Name(name),
                new Surname(surname));
        directorRepository.save(director);
        return director;
    }

}

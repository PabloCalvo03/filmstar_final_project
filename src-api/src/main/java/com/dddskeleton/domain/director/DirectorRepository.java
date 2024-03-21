package com.dddskeleton.domain.director;

import com.dddskeleton.domain.director.Director;

import java.util.Optional;


public interface DirectorRepository {

    Optional<Director> findById(DirectorId id);
    Director findByIdOrFail(DirectorId id) throws DirectorNotFound;


    void save(Director director);
}

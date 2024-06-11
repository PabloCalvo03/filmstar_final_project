package com.filmstar.domain.director;

import com.filmstar.domain.movie.MovieId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface DirectorRepository {

    Optional<Director> findById(DirectorId id);
    Director findByIdOrFail(DirectorId id) throws DirectorNotFound;
    Page<Director> findAll(Pageable pageable);
    void save(Director director);

    void deactivateDirector(DirectorId directorId) throws Exception;

    void activateDirector(DirectorId directorId) throws Exception;
}

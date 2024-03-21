package com.filmstar.application;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.director.DirectorId;
import com.filmstar.domain.director.DirectorNotFound;
import com.filmstar.domain.director.DirectorRepository;
import com.filmstar.domain.movie.*;
import com.filmstar.domain.shared.ValueError;

public class AddMovieUseCase {

    final MovieRepository movieRepository;
    final DirectorRepository directorRepository;

    public AddMovieUseCase(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public Movie execute(String id, String title, String description, String directorId) throws DirectorNotFound,
            ValueError {
        Director director = directorRepository.findByIdOrFail(new DirectorId(directorId));
        Movie movie = Movie.register(new MovieId(id), new Title(title), new Overview(description),
                new Director(director.id(), director.name(), director.surname()));
        movieRepository.save(movie);
        return movie;
    }

}

package com.filmstar.application;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.director.DirectorId;
import com.filmstar.domain.director.DirectorNotFound;
import com.filmstar.domain.director.DirectorRepository;
import com.filmstar.domain.movie.*;
import com.filmstar.domain.shared.ValueError;

/**
 * Use case for adding a new movie.
 */
public class AddMovieUseCase {

    /**
     * The repository for accessing and storing movie data.
     */
    private final MovieRepository movieRepository;

    /**
     * The repository for accessing and storing director data.
     */
    private final DirectorRepository directorRepository;

    /**
     * Constructor for the AddMovieUseCase.
     *
     * @param movieRepository the movie repository
     * @param directorRepository the director repository
     */
    public AddMovieUseCase(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    /**
     * Executes the use case for adding a new movie.
     *
     * @param id the unique identifier for the movie
     * @param title the title of the movie
     * @param description the overview of the movie
     * @param year the release year of the movie
     * @param posterImg the URL of the movie's poster image
     * @param directorId the unique identifier of the director
     * @return the newly created movie
     * @throws DirectorNotFound if the director with the given ID is not found
     * @throws ValueError if the input data is invalid
     */
    public Movie execute(String id, String title, String description, Integer year, String posterImg,
                         String directorId) throws DirectorNotFound,
            ValueError {
        Director director = directorRepository.findByIdOrFail(new DirectorId(directorId));
        Movie movie = Movie.register(new MovieId(id), new Title(title), new Overview(description),
                new PosterImg(posterImg),
                new Year(year),
                new Director(director.id(), director.name(), director.surname()));
        movieRepository.save(movie);
        return movie;
    }

}
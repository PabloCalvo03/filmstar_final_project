package com.filmstar.infrastructure.persistence.jpa;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieId;

/**
 * JPA repository for movies.
 */
@Repository
public interface JpaBridgeMovieRepository extends JpaRepository<Movie, MovieId> {

    /**
     * Finds all movies with pagination.
     *
     * @param pageable pagination information
     * @return page of movies
     */
    Page<Movie> findAll(Pageable pageable);

    /**
     * Finds all available movies with pagination.
     *
     * @param pageable pagination information
     * @return page of available movies
     */
    @Query("SELECT m FROM Movie m WHERE m.status = 'AVAILABLE'")
    Page<Movie> findAllAvailable(Pageable pageable);

    /**
     * Finds movies by title containing the given string and available status with pagination.
     *
     * @param title the title to search for
     * @param pageRequest pagination information
     * @return page of movies
     */
    @Query("SELECT m FROM Movie m WHERE m.title.value LIKE CONCAT('%', :title, '%') AND m.status = 'AVAILABLE'")
    Page<Movie> findMoviesByTitleContainingAndAvailable(@Param("title") String title, PageRequest pageRequest);

    /**
     * Deactivates a movie by setting its status to 'UNAVAILABLE'.
     *
     * @param movieId ID of the movie to deactivate
     */
    @Query("UPDATE Movie m SET m.status = 'UNAVAILABLE' WHERE m.id = :movieId")
    @Modifying
    @Transactional
    void deactivateMovie(@Param("movieId") MovieId movieId);

    /**
     * Activates a movie by setting its status to 'AVAILABLE'.
     *
     * @param movieId ID of the movie to activate
     */
    @Query("UPDATE Movie m SET m.status = 'AVAILABLE' WHERE m.id = :movieId")
    @Modifying
    @Transactional
    void activateMovie(@Param("movieId") MovieId movieId);
}
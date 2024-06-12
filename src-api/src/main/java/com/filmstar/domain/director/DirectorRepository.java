package com.filmstar.domain.director;

import com.filmstar.domain.movie.MovieId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Interface defining operations for interacting with director entities in the repository.
 */
public interface DirectorRepository {

    /**
     * Find a director by their ID.
     *
     * @param id The ID of the director to find.
     * @return An optional containing the director if found, empty otherwise.
     */
    Optional<Director> findById(DirectorId id);

    /**
     * Find a director by their ID and throw an exception if not found.
     *
     * @param id The ID of the director to find.
     * @return The director if found.
     * @throws DirectorNotFound If the director with the specified ID is not found.
     */
    Director findByIdOrFail(DirectorId id) throws DirectorNotFound;

    /**
     * Retrieve all directors with pagination support.
     *
     * @param pageable The pagination information.
     * @return A page of director entities.
     */
    Page<Director> findAll(Pageable pageable);

    /**
     * Save a director entity.
     *
     * @param director The director entity to save.
     */
    void save(Director director);

    /**
     * Deactivate a director by their ID.
     *
     * @param directorId The ID of the director to deactivate.
     * @throws Exception If an error occurs during deactivation.
     */
    void deactivateDirector(DirectorId directorId) throws Exception;

    /**
     * Activate a director by their ID.
     *
     * @param directorId The ID of the director to activate.
     * @throws Exception If an error occurs during activation.
     */
    void activateDirector(DirectorId directorId) throws Exception;
}

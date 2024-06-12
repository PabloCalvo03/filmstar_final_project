package com.filmstar.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import com.filmstar.domain.movie.MovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.director.DirectorId;
import com.filmstar.domain.director.DirectorNotFound;
import com.filmstar.domain.director.DirectorRepository;

/**
 * JPA-based implementation of the DirectorRepository interface.
 */
@Service
@Primary
public class JpaDirectorRepository implements DirectorRepository {

	/**
	 * Autowired instance of the JpaBridgeDirectorRepository.
	 */
	@Autowired
	private JpaBridgeDirectorRepository directorRepository;

	/**
	 * Finds a director by their ID.
	 *
	 * @param id the ID of the director to find
	 * @return an optional containing the director if found, or an empty optional if not found
	 */
	@Override
	public Optional<Director> findById(DirectorId id) {
		return directorRepository.findById(id);
	}

	/**
	 * Saves a director.
	 *
	 * @param director the director to save
	 */
	@Override
	public void save(Director director) {
		directorRepository.save(director);
	}

	/**
	 * Finds a director by their ID, or throws a DirectorNotFound exception if not found.
	 *
	 * @param id the ID of the director to find
	 * @return the director if found
	 * @throws DirectorNotFound if the director is not found
	 */
	@Override
	public Director findByIdOrFail(DirectorId id) throws DirectorNotFound {
		return this.findById(id).orElseThrow(() -> new DirectorNotFound(id.value()));
	}

	/**
	 * Finds all directors with pagination.
	 *
	 * @param pageable pagination information
	 * @return a page of directors
	 */
	@Override
	public Page<Director> findAll(Pageable pageable) {
		return directorRepository.findAll(pageable);
	}

	/**
	 * Deactivates a director.
	 *
	 * @param directorId the ID of the director to deactivate
	 */
	@Override
	public void deactivateDirector(DirectorId directorId) {
		directorRepository.deactivateDirector(directorId);
	}

	/**
	 * Activates a director.
	 *
	 * @param directorId the ID of the director to activate
	 */
	@Override
	public void activateDirector(DirectorId directorId) {
		directorRepository.activateDirector(directorId);
	}
}
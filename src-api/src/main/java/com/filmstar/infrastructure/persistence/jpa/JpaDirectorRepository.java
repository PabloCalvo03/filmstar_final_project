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

@Service
@Primary
public class JpaDirectorRepository implements DirectorRepository {

	@Autowired
	private JpaBridgeDirectorRepository directorRepository;

	@Override
	public Optional<Director> findById(DirectorId id) {
		return directorRepository.findById(id);
	}

	@Override
	public void save(Director director) {
		directorRepository.save(director);
	}

	@Override
	public Director findByIdOrFail(DirectorId id) throws DirectorNotFound {
		return this.findById(id).orElseThrow(()-> new DirectorNotFound(id.value()));
	}
	@Override
	public Page<Director> findAll(Pageable pageable){
		return directorRepository.findAll(pageable);
	};

	@Override
	public void deactivateDirector(DirectorId directorId) {
		directorRepository.deactivateDirector(directorId);
	};

	@Override
	public void activateDirector(DirectorId directorId) {
		directorRepository.activateDirector(directorId);
	};


}

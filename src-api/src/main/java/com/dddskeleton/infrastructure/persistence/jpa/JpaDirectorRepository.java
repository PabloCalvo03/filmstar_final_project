package com.dddskeleton.infrastructure.persistence.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dddskeleton.domain.director.Director;
import com.dddskeleton.domain.director.DirectorId;
import com.dddskeleton.domain.director.DirectorNotFound;
import com.dddskeleton.domain.director.DirectorRepository;

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

}

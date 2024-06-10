package com.filmstar.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import com.filmstar.domain.movie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class JpaMovieRepository implements MovieRepository{
	
	@Autowired
	private JpaBridgeMovieRepository movieRepository;

	@Override
	public void save(Movie movie) {
		this.movieRepository.save(movie);
	}

	@Override
	public Page<Movie> findAll(Pageable pageable) {
		return this.movieRepository.findAll(pageable);
	}

	@Override
	public Page<Movie> findAllAvailable(Pageable pageable) {
		return movieRepository.findAllAvailable(pageable);
	}

	@Override
	public Optional<Movie> findById(MovieId id) {
		return movieRepository.findById(id);
	}

	@Override
	public Movie findByIdOrFail(MovieId id) throws MovieNotFound {
		return this.findById(id).orElseThrow(()-> new MovieNotFound(id.value()));
	}

	@Override
	public Page<Movie> findMoviesByTitleContainingAndAvailable(Title title, PageRequest pageRequest){
		return movieRepository.findMoviesByTitleContainingAndAvailable(title.value(), pageRequest);
	};

	@Override
	public void deactivateMovie(MovieId movieId) {
		movieRepository.deactivateMovie(movieId);
	};

	@Override
	public void activateMovie(MovieId movieId) {
		movieRepository.activateMovie(movieId);
	};

}

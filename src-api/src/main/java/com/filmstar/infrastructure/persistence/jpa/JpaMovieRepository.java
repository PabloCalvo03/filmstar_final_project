package com.filmstar.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import com.filmstar.domain.movie.*;
import com.filmstar.domain.shared.ValueError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
	public List<Movie> findAll() {
		return this.movieRepository.findAll();
	}

	@Override
	public List<Movie> findAllAvailable() {
		return movieRepository.findAllAvailable();
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
	public List<Movie> findMoviesByTitleContainingAndAvailable(Title title){
		return movieRepository.findMoviesByTitleContainingAndAvailable(title.value());
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

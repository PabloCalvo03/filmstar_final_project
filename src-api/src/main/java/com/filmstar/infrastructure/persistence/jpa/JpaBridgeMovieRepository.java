package com.filmstar.infrastructure.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieId;

@Repository
public interface JpaBridgeMovieRepository extends JpaRepository<Movie, MovieId> {
	@Query("SELECT m FROM Movie m WHERE m.status = 'AVAILABLE'")
    List<Movie> findAllAvailable();
}

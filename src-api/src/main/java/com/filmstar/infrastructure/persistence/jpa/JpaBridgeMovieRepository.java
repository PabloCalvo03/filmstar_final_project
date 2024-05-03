package com.filmstar.infrastructure.persistence.jpa;

import java.util.List;

import com.filmstar.domain.movie.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.movie.Movie;
import com.filmstar.domain.movie.MovieId;

@Repository
public interface JpaBridgeMovieRepository extends JpaRepository<Movie, MovieId> {
	@Query("SELECT m FROM Movie m WHERE m.status = 'AVAILABLE'")
    List<Movie> findAllAvailable();

    @Query("SELECT m FROM Movie m WHERE m.title.value LIKE CONCAT(:title, '%')")
    List<Movie> findMoviesByTitleStartingWith(@Param("title") String title);

}

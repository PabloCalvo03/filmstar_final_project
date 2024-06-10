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

@Repository
public interface JpaBridgeMovieRepository extends JpaRepository<Movie, MovieId> {
    Page<Movie> findAll(Pageable pageable);
	@Query("SELECT m FROM Movie m WHERE m.status = 'AVAILABLE'")
    Page<Movie> findAllAvailable(Pageable pageable);

    @Query("SELECT m FROM Movie m WHERE m.title.value LIKE CONCAT('%', :title, '%') AND m.status = 'AVAILABLE'")
    Page<Movie> findMoviesByTitleContainingAndAvailable(@Param("title") String title, PageRequest pageRequest);

    @Query("UPDATE Movie m SET m.status = 'UNAVAILABLE' WHERE m.id = :movieId")
    @Modifying
    @Transactional
    void deactivateMovie(@Param("movieId") MovieId movieId);

    @Query("UPDATE Movie m SET m.status = 'AVAILABLE' WHERE m.id = :movieId")
    @Modifying
    @Transactional
    void activateMovie(@Param("movieId") MovieId movieId);

}

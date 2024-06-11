package com.filmstar.infrastructure.persistence.jpa;

import com.filmstar.domain.movie.MovieId;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.director.DirectorId;

@Repository
public interface JpaBridgeDirectorRepository extends JpaRepository<Director, DirectorId> {
    Page<Director> findAll(Pageable pageable);

    @Query("UPDATE Director d SET d.status = 'UNAVAILABLE' WHERE d.id = :directorId")
    @Modifying
    @Transactional
    void deactivateDirector(@Param("directorId") DirectorId directorId);

    @Query("UPDATE Director d SET d.status = 'AVAILABLE' WHERE d.id = :directorId")
    @Modifying
    @Transactional
    void activateDirector(@Param("directorId") DirectorId directorId);
}

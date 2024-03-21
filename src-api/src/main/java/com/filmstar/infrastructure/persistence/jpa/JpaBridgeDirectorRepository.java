package com.filmstar.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.director.Director;
import com.filmstar.domain.director.DirectorId;

@Repository
public interface JpaBridgeDirectorRepository extends JpaRepository<Director, DirectorId> {
}

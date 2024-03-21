package com.dddskeleton.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dddskeleton.domain.director.Director;
import com.dddskeleton.domain.director.DirectorId;

@Repository
public interface JpaBridgeDirectorRepository extends JpaRepository<Director, DirectorId> {
}

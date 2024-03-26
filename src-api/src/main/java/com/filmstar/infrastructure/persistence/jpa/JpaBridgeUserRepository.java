package com.filmstar.infrastructure.persistence.jpa;

import java.util.Optional;

import com.filmstar.domain.user.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserId;
import com.filmstar.domain.user.Username;

@Repository
public interface JpaBridgeUserRepository extends JpaRepository<User, UserId>{

	@Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findByUsername(Username username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(Email email);

}

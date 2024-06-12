package com.filmstar.infrastructure.persistence.jpa;

import java.util.Optional;

import com.filmstar.domain.user.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserId;
import com.filmstar.domain.user.Username;

/**
 * JPA repository for users.
 */
@Repository
public interface JpaBridgeUserRepository extends JpaRepository<User, UserId> {

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return an optional containing the user if found, or an empty optional if not found
     */
    @Query("SELECT u FROM User u WHERE u.username =?1")
    Optional<User> findByUsername(Username username);

    /**
     * Finds a user by their email.
     *
     * @param email the email to search for
     * @return an optional containing the user if found, or an empty optional if not found
     */
    @Query("SELECT u FROM User u WHERE u.email =?1")
    Optional<User> findByEmail(Email email);
}
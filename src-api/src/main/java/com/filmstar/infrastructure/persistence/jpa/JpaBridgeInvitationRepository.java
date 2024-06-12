package com.filmstar.infrastructure.persistence.jpa;

import com.filmstar.domain.user.Invitation;
import com.filmstar.domain.user.InvitationNotFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA repository for invitations.
 */
@Repository
public interface JpaBridgeInvitationRepository extends JpaRepository<Invitation, Long> {

    /**
     * Finds an invitation by its code.
     *
     * @param code the code of the invitation to find
     * @return an optional containing the invitation if found, or an empty optional if not found
     */
    Optional<Invitation> findByCode(String code);

    /**
     * Saves an invitation to the database.
     *
     * @param invitation the invitation to save
     * @return the saved invitation
     */
    Invitation save(Invitation invitation);
}
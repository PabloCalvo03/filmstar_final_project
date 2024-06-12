package com.filmstar.domain.user;

import java.util.Optional;

/**
 * Represents a repository for managing invitations.
 */
public interface InvitationRepository {

    /**
     * Finds an invitation by its code.
     *
     * @param code the code of the invitation to find
     * @return an Optional containing the invitation if found, or an empty Optional if not found
     */
    Optional<Invitation> findByCode(String code);

    /**
     * Finds an invitation by its code, or throws an InvitationNotFound exception if not found.
     *
     * @param code the code of the invitation to find
     * @return the invitation if found
     * @throws InvitationNotFound if the invitation is not found
     */
    Invitation findByCodeOrFail(String code) throws InvitationNotFound;

    /**
     * Saves an invitation to the repository.
     *
     * @param invitation the invitation to save
     * @return the saved invitation
     */
    Invitation save(Invitation invitation);
}
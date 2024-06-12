package com.filmstar.infrastructure.persistence.jpa;

import com.filmstar.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA-based implementation of the InvitationRepository interface.
 */
@Repository
public class JpaInvitationRepository implements InvitationRepository {

	/**
	 * Autowired instance of the JpaBridgeInvitationRepository.
	 */
	@Autowired
	private JpaBridgeInvitationRepository invitationRepository;

	/**
	 * Finds an invitation by its code.
	 *
	 * @param code the code of the invitation to find
	 * @return an optional containing the invitation if found, or an empty optional if not found
	 */
	public Optional<Invitation> findByCode(final String code) {
		return invitationRepository.findByCode(code);
	}

	/**
	 * Finds an invitation by its code, or throws an InvitationNotFound exception if not found.
	 *
	 * @param code the code of the invitation to find
	 * @return the invitation if found
	 * @throws InvitationNotFound if the invitation is not found
	 */
	@Override
	public Invitation findByCodeOrFail(final String code) throws InvitationNotFound {
		return this.findByCode(code).orElseThrow(() -> new InvitationNotFound(code));
	}

	/**
	 * Saves an invitation.
	 *
	 * @param invitation the invitation to save
	 * @return the saved invitation
	 */
	@Override
	public Invitation save(final Invitation invitation) {
		return invitationRepository.save(invitation);
	}
}
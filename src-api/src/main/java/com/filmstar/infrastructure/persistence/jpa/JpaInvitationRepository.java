package com.filmstar.infrastructure.persistence.jpa;

import com.filmstar.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaInvitationRepository implements InvitationRepository{
	
	@Autowired
	private JpaBridgeInvitationRepository invitationRepository;

	public Optional<Invitation> findByCode(final String code) {
		return invitationRepository.findByCode(code);
	}

	@Override
	public Invitation findByCodeOrFail(final String code) throws InvitationNotFound {
		return this.findByCode(code).orElseThrow(() -> new InvitationNotFound(code));
	}

	@Override
	public Invitation save(final Invitation invitation) {
	    return invitationRepository.save(invitation);
	}

}

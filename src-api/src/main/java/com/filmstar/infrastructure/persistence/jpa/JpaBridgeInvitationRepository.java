package com.filmstar.infrastructure.persistence.jpa;

import com.filmstar.domain.user.Invitation;
import com.filmstar.domain.user.InvitationNotFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaBridgeInvitationRepository extends JpaRepository<Invitation, Long> {

    Optional<Invitation> findByCode(String code);
    Invitation save(Invitation invitation);
}

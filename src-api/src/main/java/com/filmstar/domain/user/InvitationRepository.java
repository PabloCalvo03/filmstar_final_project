package com.filmstar.domain.user;

import java.util.Optional;

public interface InvitationRepository {

    Optional<Invitation> findByCode(String code);

    Invitation findByCodeOrFail(String code) throws InvitationNotFound;

    Invitation save(Invitation invitation);


}

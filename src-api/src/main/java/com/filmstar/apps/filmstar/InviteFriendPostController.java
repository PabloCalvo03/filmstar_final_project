package com.filmstar.apps.filmstar;

import com.filmstar.apps.shared.SerializedInvitation;
import com.filmstar.domain.movie.MovieRepository;
import com.filmstar.domain.user.Invitation;
import com.filmstar.domain.user.InvitationRepository;
import com.filmstar.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for inviting a friend in the Filmstar application.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/filmstar/invite-friend")
@Qualifier("filmstar")
public class InviteFriendPostController {

    @Autowired
    private InvitationRepository invitationRepository;

    /**
     * Invites a friend to the Filmstar application.
     *
     * @param user the authenticated user sending the invitation
     * @param inviteFriendPostRequest the request containing the friend's first name and last name
     * @return a ResponseEntity with the serialized invitation and HTTP status 202 if the invitation is successful,
     *         or an error message and HTTP status 400 if the request is invalid
     */
    @PostMapping
    public ResponseEntity<?> execute(@AuthenticationPrincipal User user,
                                     @RequestBody InviteFriendPostRequest inviteFriendPostRequest) {
        try {
            Invitation invitation = new Invitation(inviteFriendPostRequest.firstname, inviteFriendPostRequest.lastname, user);
            invitationRepository.save(invitation);
            return new ResponseEntity<>(SerializedInvitation.from(invitation), HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

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

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/movierecords/invite-friend")
@Qualifier("movierecords")
public class InviteFriendPostController {

    @Autowired
    private InvitationRepository invitationRepository;

    @PostMapping
    public ResponseEntity<SerializedInvitation> execute(@AuthenticationPrincipal User user,
                        @RequestBody InviteFriendPostRequest inviteFriendPostRequest){
    	Invitation invitation = new Invitation(inviteFriendPostRequest.firstname, inviteFriendPostRequest.lastname, user);
        invitationRepository.save(invitation);
    	return new ResponseEntity<SerializedInvitation>(SerializedInvitation.from(invitation), HttpStatus.ACCEPTED);
    }

}

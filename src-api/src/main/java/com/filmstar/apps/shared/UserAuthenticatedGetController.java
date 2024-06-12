package com.filmstar.apps.shared;

import com.filmstar.domain.user.User;
import com.filmstar.domain.user.UserNotFound;
import com.filmstar.domain.user.UserRepository;
import com.filmstar.domain.user.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST controller for retrieving authenticated user details.
 */
@RestController
@RequestMapping(value = "/api/users/me")
@CrossOrigin("*")
public class UserAuthenticatedGetController {

        /**
         * Retrieves details of the authenticated user.
         *
         * @param user the authenticated user
         * @return a ResponseEntity with the authenticated user details if successful,
         *         or an error message and HTTP status 404 (Not Found) if the user is not found
         */
        @GetMapping
        public ResponseEntity<?> getUser(@AuthenticationPrincipal User user) {
                SerializedUser serializedUser = SerializedUser.from(user);
                return new ResponseEntity<>(serializedUser, HttpStatus.OK);
        }
}

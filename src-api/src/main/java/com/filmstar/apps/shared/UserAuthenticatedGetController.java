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

@RestController
@RequestMapping(value = "/api/users/me")
@CrossOrigin("*")
public class UserAuthenticatedGetController {

        @GetMapping
        public ResponseEntity<?> getUser(@AuthenticationPrincipal User user) {
                return new ResponseEntity<>(SerializedUser.from(user), HttpStatus.OK);
        }
}

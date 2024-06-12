package com.filmstar.apps.shared;

import com.filmstar.domain.user.BadInvitation;
import com.filmstar.domain.user.EmailAlreadyExists;
import com.filmstar.domain.user.InvitationNotFound;
import com.filmstar.infrastructure.authentication.UserRegister;
import com.filmstar.domain.user.UsernameAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for user signup.
 */
@RestController
@RequestMapping(value = "/api/signup")
@CrossOrigin("*")
public class SignupPostController {

	@Autowired
	private UserRegister userRegister;

	/**
	 * Registers a new user.
	 *
	 * @param userSignupPostRequest the request containing user signup details
	 * @return a ResponseEntity with the registered user details if successful,
	 *         or an error message and HTTP status 409 (Conflict) if registration fails
	 */
	@PostMapping
	public ResponseEntity<?> register(@RequestBody UserSignupPostRequest userSignupPostRequest) {
		try {
			final UserResponse userResponse = userRegister.register(userSignupPostRequest);
			return ResponseEntity.ok(userResponse);
		} catch (IllegalArgumentException | EmailAlreadyExists | UsernameAlreadyExists | InvitationNotFound | BadInvitation e) {
			final HttpStatus httpStatus = HttpStatus.CONFLICT;
			final LoginPostController.ErrorResponse errorResponse = new LoginPostController.ErrorResponse(httpStatus.value(), e.getMessage());
			return ResponseEntity.status(httpStatus).body(errorResponse);
		}
	}
}

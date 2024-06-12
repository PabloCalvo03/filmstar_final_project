package com.filmstar.apps.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.filmstar.infrastructure.authentication.UserAuthenticator;
import com.filmstar.domain.user.InvalidAuthUsername;
import com.filmstar.domain.user.InvalidAuthPassword;

/**
 * REST controller for handling user login requests.
 */
@RestController
@RequestMapping(value = "/api/login")
@CrossOrigin("*")
public class LoginPostController {

	@Autowired
	private UserAuthenticator userAuthenticator;

	/**
	 * Authenticates a user based on the provided login credentials.
	 *
	 * @param userLoginPostRequest the user login request containing the username and password
	 * @return a ResponseEntity containing the user response if authentication is successful,
	 *         or an error response if authentication fails
	 */
	@PostMapping
	public ResponseEntity<?> login(@RequestBody UserLoginPostRequest userLoginPostRequest) {
		try {
			final UserResponse userResponse = userAuthenticator.authenticate(userLoginPostRequest);
			return ResponseEntity.ok(userResponse);
		} catch (InvalidAuthUsername | InvalidAuthPassword e) {
			final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
			final ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), e.getMessage());
			return ResponseEntity.status(httpStatus).body(errorResponse);
		}
	}

	/**
	 * Class representing an error response.
	 */
	public static class ErrorResponse {
		Integer code;
		String message;

		public ErrorResponse() {

		}

		public ErrorResponse(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		public Integer getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}

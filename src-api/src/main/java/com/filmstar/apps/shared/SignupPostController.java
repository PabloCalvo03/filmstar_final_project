package com.filmstar.apps.shared;

import com.filmstar.domain.user.EmailAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmstar.infrastructure.authentication.UserRegister;
import com.filmstar.application.shared.ErrorResponse;
import com.filmstar.application.shared.UserResponse;
import com.filmstar.domain.user.UsernameAlreadyExists;

@RestController
@RequestMapping(value = "api/signup")
public class SignupPostController {
	
	@Autowired
	private UserRegister userRegister;

	  @PostMapping
	  public ResponseEntity<?> register(@RequestBody UserSignupPostRequest userSignupPostRequest) {
	    try {
	      final UserResponse userResponse = userRegister.register(userSignupPostRequest);
	      return ResponseEntity.ok(userResponse);
	    } catch (IllegalArgumentException | EmailAlreadyExists | UsernameAlreadyExists e) {
	      final HttpStatus httpStatus = HttpStatus.CONFLICT;
	      final ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), e.getMessage());
	      return ResponseEntity.status(httpStatus).body(errorResponse);
	    }
	}
}

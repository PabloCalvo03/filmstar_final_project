package com.filmstar.apps.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.filmstar.infrastructure.authentication.UserAuthenticator;
import com.filmstar.application.shared.ErrorResponse;
import com.filmstar.application.shared.UserResponse;
import com.filmstar.domain.user.InvalidAuthUsername;
import com.filmstar.domain.user.InvalidAuthPassword;

@RestController
@RequestMapping(value = "/api/login")
@CrossOrigin("*")
public class LoginPostController {
	
	@Autowired
	private UserAuthenticator userAuthenticator;
	
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

}

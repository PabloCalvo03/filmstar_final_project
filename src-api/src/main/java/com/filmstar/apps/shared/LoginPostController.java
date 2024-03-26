package com.filmstar.apps.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmstar.application.UserAuthenticator;
import com.filmstar.application.shared.ErrorResponse;
import com.filmstar.application.shared.UserAuthRequest;
import com.filmstar.application.shared.UserResponse;
import com.filmstar.domain.user.InvalidAuthUsername;
import com.filmstar.domain.user.InvalidAuthPassword;

@RestController
@RequestMapping(value = "/api/login")
public class LoginPostController {
	
	@Autowired
	private UserAuthenticator userAuthenticator;
	
	 @PostMapping
	  public ResponseEntity<?> login(@RequestBody UserAuthRequest userAuthRequest) {
	    try {
	      final UserResponse userResponse = userAuthenticator.authenticate(userAuthRequest);
	      return ResponseEntity.ok(userResponse);
	    } catch (InvalidAuthUsername | InvalidAuthPassword e) {
	      final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
	      final ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), e.getMessage());
	      return ResponseEntity.status(httpStatus).body(errorResponse);
	    }
	  }

}

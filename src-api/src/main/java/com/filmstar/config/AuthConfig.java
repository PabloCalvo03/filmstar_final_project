package com.filmstar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.filmstar.application.AuthenticationTokenValidator;
import com.filmstar.domain.user.Role;
import com.filmstar.middleware.BearerAuthMiddleware;

@Configuration
@EnableWebSecurity
public class AuthConfig {
	
	private AuthenticationTokenValidator authenticationTokenValidator;
	
	public AuthConfig(AuthenticationTokenValidator authenticationTokenValidator) {
		this.authenticationTokenValidator = authenticationTokenValidator;
	}

	  @Bean
	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.addFilterBefore(
	            new BearerAuthMiddleware(authenticationTokenValidator), BasicAuthenticationFilter.class)
	        .csrf(AbstractHttpConfigurer::disable)
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .authorizeHttpRequests(
	            (requests) ->
	                requests
	                    .requestMatchers(HttpMethod.POST, "/api/login", "/api/signup")
	                    .permitAll()
	                    .requestMatchers(HttpMethod.GET, "/api/movierecords/movies")
                        .hasAnyRole(Role.USER.name())
						.requestMatchers(HttpMethod.GET, "/api/backoffice/movies")
						.hasAnyRole(Role.ADMIN.name())
	                    .anyRequest()
	                    .authenticated());
	    return http.build();
	  }
}

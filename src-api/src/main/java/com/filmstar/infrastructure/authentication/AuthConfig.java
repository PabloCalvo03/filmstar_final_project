package com.filmstar.infrastructure.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.filmstar.infrastructure.authentication.AuthenticationTokenValidator;
import com.filmstar.domain.user.Role;
import com.filmstar.apps.BearerAuthMiddleware;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Configuration class for authentication and security settings.
 */
@Configuration
@EnableWebSecurity
public class AuthConfig {

	/**
	 * Authentication token validator instance.
	 */
	private AuthenticationTokenValidator authenticationTokenValidator;

	/**
	 * Constructor for AuthConfig.
	 *
	 * @param authenticationTokenValidator the authentication token validator instance
	 */
	public AuthConfig(AuthenticationTokenValidator authenticationTokenValidator) {
		this.authenticationTokenValidator = authenticationTokenValidator;
	}

	/**
	 * Bean for security filter chain configuration.
	 *
	 * @param http the HttpSecurity instance
	 * @return the configured SecurityFilterChain
	 * @throws Exception if an error occurs during configuration
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors().and()
				.addFilterBefore(
						new BearerAuthMiddleware(authenticationTokenValidator),
						BasicAuthenticationFilter.class)
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						(requests) ->
								requests
										.requestMatchers(HttpMethod.POST, "/api/login", "/api/signup").permitAll()
										.requestMatchers(HttpMethod.GET, "/api/filmstar/*").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
										.requestMatchers(HttpMethod.GET, "/api/backoffice/*").hasAnyRole(Role.ADMIN.name())
										.requestMatchers(HttpMethod.PUT, "/api/filmstar/*").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
										.requestMatchers(HttpMethod.PUT, "/api/backoffice/*").hasAnyRole(Role.ADMIN.name())
										.anyRequest().authenticated());
		return http.build();
	}



}
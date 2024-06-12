package com.filmstar.apps;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.filmstar.infrastructure.authentication.AuthenticationTokenValidator;
import com.filmstar.domain.user.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This class implements a filter to intercept incoming HTTP requests and authenticate them using bearer tokens.
 */
public class BearerAuthMiddleware extends OncePerRequestFilter {

	private AuthenticationTokenValidator authenticationTokenValidator;

	/**
	 * Constructs a BearerAuthMiddleware with the provided AuthenticationTokenValidator.
	 *
	 * @param authenticationTokenValidator the token validator
	 */
	public BearerAuthMiddleware(AuthenticationTokenValidator authenticationTokenValidator) {
		this.authenticationTokenValidator = authenticationTokenValidator;
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest httpServletRequest,
									final HttpServletResponse httpServletResponse, final FilterChain filterChain)
			throws ServletException, IOException {

		final String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

		if (header == null) {
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}

		final String[] authElements = header.split(" ");

		if (authElements.length != 2 || "Bearer".equals(authElements[0]) == false) {
			filterChain.doFilter(httpServletRequest, httpServletResponse);
			return;
		}

		try {
			final User user = authenticationTokenValidator.validateToken(authElements[1]);
			Collection<SimpleGrantedAuthority> roles =
					Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.role().name()));

			final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					user,
					null,
					roles
			);

			SecurityContextHolder.getContext().setAuthentication(authToken);

		} catch (final RuntimeException e) {
			SecurityContextHolder.clearContext();
			throw e;
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}

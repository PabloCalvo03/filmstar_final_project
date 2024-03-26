package com.filmstar.application;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.filmstar.domain.user.AuthenticationTokenProvider;
import com.filmstar.domain.user.Role;
import com.filmstar.domain.user.Token;
import com.filmstar.domain.user.Username;

@Service
public class JwtAuthenticationTokenProvider implements AuthenticationTokenProvider {

    @Value("${security.jwt.token.secret-key:default-secret-key}")
    private String secretKey;

    public void JwtTokenProvider(String secretKey) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    @Override
    public Token createToken(Username username, Role role) {
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + 3600000); // 1 hour

        final Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return new Token(
                JWT.create()
                        .withSubject(username.value())
                        .withClaim("role", role.name()) // Include role information in the token
                        .withIssuedAt(now)
                        .withExpiresAt(validity)
                        .sign(algorithm));
    }

    @Override
    public Username validateToken(final Token token) {
        final Algorithm algorithm = Algorithm.HMAC256(secretKey);
        final JWTVerifier verifier = JWT.require(algorithm).build();
        final DecodedJWT decoded = verifier.verify(token.value());

        // Extract role information from the token
        String role = decoded.getClaim("role").asString();

        return new Username(decoded.getSubject());
    }
}

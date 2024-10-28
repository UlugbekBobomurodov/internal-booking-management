package com.example.internalbookingmanagement.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;


@Component
@Setter
public class JwtService {
    @Value("${app.jwtSecret}")
    private String jwtSecret;
    @Value("${app.accessJwtExpirationInMs}")
    private int accessJwtExpirationInMs;
    @Value("${app.refreshJwtExpirationInMs}")
    private int refreshJwtExpirationInMs;

    public String generateAccessToken(UserDetails user) {
        return Jwts.builder()
                .signWith(generateSecretKey())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + accessJwtExpirationInMs))
                .claim("roles", user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining()))
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .signWith(generateSecretKey(), SignatureAlgorithm.HS256)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshJwtExpirationInMs))
                .compact();
    }

    public Key generateSecretKey() {
        byte[] bytes = jwtSecret.getBytes();
        return Keys.hmacShaKeyFor(bytes);
    }


    public String extractUsernameFromJWT(String token) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(generateSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody().getSubject();
        } catch (ExpiredJwtException e) {
            return "Token has expired";
        }
    }

    public Boolean isValid(String token) {
        try {
            Jwts
                    .parserBuilder()
                    .setSigningKey(generateSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody().getSubject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package br.com.studio.beautymanager.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET = "beautymanager-secret-key-123456789";

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String gerarToken(Long studioId) {

        return Jwts.builder()
                .claim("studioId", studioId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(getKey())
                .compact();
    }

    public Long getStudioId(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();

        return Long.valueOf(claims.get("studioId").toString());
    }
}
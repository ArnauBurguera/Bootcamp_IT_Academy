package com.BurgueraCallesArnau.s05t02n01.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    private static Environment environment;

    @NonNull private static final String SECRET_KEY = environment.getProperty("secret.key");
    public String extractUserName(String token) {
        return null;
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

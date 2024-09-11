package com.nullpay.wallet.config.security;

import com.nullpay.wallet.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
        // extract jwt secret from application.properties
        private final String JWT_SECRET_KEY = "nullpaysecretnullpaysecretnullpaysecretnullpaysecretnullpaysecretnullpaysecret";


    public String extractUserId(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    public String generateToken(UserDetails userDetails) {
        return this.generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userId = extractUserId(token);
        final User user = (User) userDetails;
        return (userId.equals(user.getId()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        Jws<Claims> jwsClaims = Jwts.parserBuilder()
                .setSigningKey(this.JWT_SECRET_KEY)
                .build()
                .parseClaimsJws(token);
        return jwsClaims.getBody();
//        return (Claims) Jwts.parserBuilder()
//                .setSigningKey(this.JWT_SECRET_KEY)
//                .build()
//                .parseClaimsJws(token);
    }


    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        int tokenExpirationInMilliSeconds = 1000 * 60 * 60 * 10;
        User user = (User) userDetails;
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpirationInMilliSeconds))
                .signWith(SignatureAlgorithm.HS256, this.JWT_SECRET_KEY)
                .compact();
    }

    public String getSecretKey() {
        return JWT_SECRET_KEY;
    }
}

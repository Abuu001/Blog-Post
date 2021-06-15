package com.example.demo.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    @Value("${app.JWTSECRET}")
    private String secret;

    //generate Token
    public String generateToken(String subject){

        return Jwts.builder()
                .setSubject(subject)
                .setIssuer("Abraham")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
                .signWith(SignatureAlgorithm.HS256,secret.getBytes())
                .compact();
    }

    //read claims
    public Claims getClaims(String token){
        return  Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    //Read exp date
    public  Date getExpDate(String token){
        return getClaims(token).getExpiration();
    }

    //read subject/username
    public  String getUserName(String token){
        return getClaims(token).getSubject();
    }

    // validate Exp date
    public boolean isTokenExpired(String token){
        Date expDate = getExpDate(token);
        return expDate.before(new Date(System.currentTimeMillis()));
    }

    //validate usename in token and database expdate
    public  boolean validToken(String token,String username){
        String tokenUserName =getUserName(token);
        return (username.equals(tokenUserName) && !isTokenExpired(token));
    }


}

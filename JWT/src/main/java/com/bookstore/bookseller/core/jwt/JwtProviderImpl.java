package com.bookstore.bookseller.core.jwt;

import com.bookstore.bookseller.core.security.UserPrincipal;
import com.bookstore.bookseller.core.util.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtProviderImpl implements JwtProvider{

    @Value("${app.jwt.secret}")
    private String JWT_SECRET;

    @Value("${app.jwt.expiration-in-ms}")
    private Long JWT_EXPIRATION_IN_MS;



    @Override
    public String generateToken(UserPrincipal userPrincipal){
        String authorities = userPrincipal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));



        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .claim("roles",authorities)
                .claim("userId",userPrincipal.getId())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }

    @Override
    public Authentication getAuthentication(HttpServletRequest request){
        Claims claims = extractClaims(request);
        if(claims == null){
            return null;
        }

        String username = claims.getSubject();
        Long userId = claims.get("userId",Long.class);

        Set<GrantedAuthority> authorities = Arrays
                .stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertToAuthority)
                .collect(Collectors.toSet());

        UserDetails userDetails = UserPrincipal.builder()
                .username(username)
                .authorities(authorities)
                .id(userId)
                .build();

        if(username == null){
            return null;
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,authorities);
    }

    @Override
    public boolean validateToken(HttpServletRequest request){
        Claims claims = extractClaims(request);
        if(claims == null){
            return false;
        }
        if(claims.getExpiration().before(new Date())){
            return false; //not valid
        }
        return true;
    }

    private Claims extractClaims(HttpServletRequest request){
        String token = SecurityUtils.extractAuthTokenFromRequest(request);

        if(token == null){
            return null;
        }

        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }


}

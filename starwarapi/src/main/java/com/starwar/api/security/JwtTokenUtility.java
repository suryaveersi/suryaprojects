package com.starwar.api.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.security.auth.Subject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenUtility {
	
	private static final long serialVersionUID = -255185165626007488L;

	   @Value("${jwt.secret}")
	    private String secretkey;

	    
	    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	
	    public String getUsernameFromToken(String token)
	    {
	    	return getClaimFromToken(token, Claims::getSubject);
	    }
	    
	    public Date getExpirationDateFromToken(String token)
	    {
	    	return getClaimFromToken(token, Claims::getExpiration);
	    }
	    
	    private <T> T getClaimFromToken(String token,Function<Claims, T> claimsResolver) {
			// TODO Auto-generated method stub
	    	 final Claims claims = getAllClaimsFromToken(token);
		        return claimsResolver.apply(claims);
		}

	  
	    private Claims getAllClaimsFromToken(String token) {
			// TODO Auto-generated method stub
	    	return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
		}

		
	  

		private Boolean isTokenExpired(String token) {
			final Date expiration = getExpirationDateFromToken(token);
	        return expiration.before(new Date());
	    }

	    public String generateToken(UserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        return doGenerateToken(claims, userDetails.getUsername());
	    }

	    private String doGenerateToken(Map<String, Object> claims, String username) {
			// TODO Auto-generated method stub
	    	return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
	                .signWith(SignatureAlgorithm.HS256, secretkey).compact();
	    
		}

	

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = getUsernameFromToken(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
	}
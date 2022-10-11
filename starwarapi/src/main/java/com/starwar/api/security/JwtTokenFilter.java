package com.starwar.api.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.starwar.api.service.CustomUserDetailService;


@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtility jwtUtil;

    @Autowired
    private CustomUserDetailService userservice;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!hasAuthorizationBearer(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getAccessToken(request);
        String username = jwtUtil.getUsernameFromToken(token);
        if(null != username && SecurityContextHolder.getContext().getAuthentication()==null)
        {
        	UserDetails userdetails = userservice.loadUserByUsername(username);
        
        
        if(jwtUtil.validateToken(token, userdetails))
        {
        	UsernamePasswordAuthenticationToken usernamepasswordauthenticationtoken = new UsernamePasswordAuthenticationToken(userdetails, null, userdetails.getAuthorities());
        	usernamepasswordauthenticationtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        	
        	SecurityContextHolder.getContext().setAuthentication(usernamepasswordauthenticationtoken);
        }
        
        }
        
        System.out.println("URL" + request.getRequestURL());
       

        filterChain.doFilter(request, response);
    }

    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
            return false;
        }

        return true;
    }

    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.substring(7);
        return token;
    }

    
   

}
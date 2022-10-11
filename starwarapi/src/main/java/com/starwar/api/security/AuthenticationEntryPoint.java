package com.starwar.api.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());


        String errorResponse = "{\n" +
                "  \"code\": \"401\",\n" +
                "  \"reason\": \"Unautherized\",\n" +
                "}";

       // log.info("JSON payload :" + errorResponse);
        PrintWriter out = response.getWriter();
        out.print(errorResponse);
        out.flush();
        out.close();
	}
	
	 @Override
	    public void afterPropertiesSet() {
	        setRealmName("user repo");
	        super.afterPropertiesSet();
	    }

	 
}

package com.starwar.api.model;

public class JwtResponse {
	
	private String jwtToken;
	
	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String token) {
		// TODO Auto-generated constructor stub
		this.jwtToken = token;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}

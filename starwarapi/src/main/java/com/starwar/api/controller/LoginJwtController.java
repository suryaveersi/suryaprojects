package com.starwar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwar.api.model.JwtRequest;
import com.starwar.api.model.JwtResponse;
import com.starwar.api.security.JwtTokenUtility;
import com.starwar.api.service.CustomUserDetailService;

@RestController
@RequestMapping
public class LoginJwtController {
	
	@Autowired
	private JwtTokenUtility jwtTokenUtility;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@GetMapping("/starwar")
	public String home()
	{
		return "Welcome to star War";
	}
	
	@PostMapping("/authenticatetoken")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtrequest) throws Exception
	{
		try
		{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getUsername(), jwtrequest.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Invalid Creadentials", e);
		}
		
		final UserDetails userdetails = customUserDetailService.loadUserByUsername(jwtrequest.getUsername());
		final String token = jwtTokenUtility.generateToken(userdetails);
		
		return new JwtResponse(token);
	}
	


}

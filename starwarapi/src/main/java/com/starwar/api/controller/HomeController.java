package com.starwar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.starwar.api.model.JwtRequest;
import com.starwar.api.model.JwtResponse;
import com.starwar.api.security.JwtTokenUtility;
import com.starwar.api.service.CustomUserDetailService;

@RestController
@RequestMapping
public class HomeController {
	
	@Autowired
	private JwtTokenUtility jwtutil;

	
	@Autowired
	private AuthenticationManager authenticatemanager;
	
	@Autowired
	private CustomUserDetailService userservice;
	
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
		authenticatemanager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getUsername(), jwtrequest.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Invalid Creadentials", e);
		}
		
		final UserDetails userdetails = userservice.loadUserByUsername(jwtrequest.getUsername());
		final String token = jwtutil.generateToken(userdetails);
		
		return new JwtResponse(token);
	}
	


}

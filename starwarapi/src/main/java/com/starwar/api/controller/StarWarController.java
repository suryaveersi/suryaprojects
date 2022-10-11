package com.starwar.api.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.starwar.api.model.Planet;
import com.starwar.api.model.Type;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/starwar")
public class StarWarController {
	
	
	@Autowired
	@Lazy
	RestTemplate reststarapi;
	
	
	private static final String BASE_URL = "http://swapi.dev/api";
	
	
	@GetMapping(value="/api/{type}",produces=MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name="StarWarService", fallbackMethod = "getdefaultuser")
	public List<Type> getuserdata(@PathVariable("type") String type)
	{
		
			Type typeplanet = new Planet();
			List<Type> persontype = typeplanet.data();
			return persontype;
			
	}
	
	@RequestMapping(value="/api/{type}/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name="StarWarService", fallbackMethod = "getdefaultuser2")
	public Type getuserdata(@PathVariable("type") String type,@PathVariable("id") String id)
	{
		
			Type typeplanet = new Planet();
			List<Type> persontype = typeplanet.data();
			persontype.stream().findFirst().get();
			return persontype.stream().findFirst().get();
			
	}
	
	
	
		public List<Type> getdefaultuser(Exception e)
		
		{
			Type typeplanet = new Planet();
			List<Type> persontype = typeplanet.data();
			
			
			return persontype;
			
		}
	
		public Type getdefaultuser2(Exception e)
		
		{
		Type typeplanet = new Planet();
		List<Type> persontype = typeplanet.data();
		persontype.stream().findFirst().get();
		return persontype.stream().findFirst().get();
			
		}
	
		@Bean
		public RestTemplate resttempalate()
		{
		   return new RestTemplate();
		}
	

}

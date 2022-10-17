package com.starwar.api.controller;


import java.util.List;
import com.starwar.api.dto.StarWarResponse;
import com.starwar.api.service.FilmService;
import com.starwar.api.service.PeopleService;
import com.starwar.api.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/starwar")
public class StarWarController {
	
	
	@Autowired
	@Lazy
	RestTemplate reststarapi;

	@Autowired
	PlanetService planetService;

    @Autowired
	FilmService filmService;

	@Autowired
	PeopleService peopleService;
	
	private static final String BASE_URL = "http://swapi.dev/api";


	@GetMapping(value="/api/{type}",produces=MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name="StarWarService", fallbackMethod = "getDefaultUser")
	public List<StarWarResponse> getAllDataByType(@PathVariable("type") String type)
	{

		if(type.equals("planet"))
		{
			List<StarWarResponse> planetResponses = planetService.getAllData();
			return planetResponses;
		}

		if(type.equals("film"))
		{
			List<StarWarResponse> filmResponses = filmService.getAllData();
			return filmResponses;
		}

		if(type.equals("people"))
		{
			List<StarWarResponse> peopleResponses = peopleService.getAllData();
			return peopleResponses;
		}

		else {
			throw new InvalidEndpointRequestException("Star War Item not Found", "Not a valid Type");
		}
			
	}
	
	@RequestMapping(value="/api/{type}/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public StarWarResponse getStarWarDataById(@PathVariable("type") String type, @PathVariable("id") Integer id)
	{

		if(type.equals("planet"))
		{
			StarWarResponse planeDataById = planetService.getDataById(id);

			return planeDataById;
		}
		if(type.equals("film"))
		{
			StarWarResponse filmDataById = filmService.getDataById(id);

			return filmDataById;
		}

		if(type.equals("people"))
		{
			StarWarResponse peopleDataById = peopleService.getDataById(id);

			return peopleDataById;
		}

		else {
			throw new InvalidEndpointRequestException("Star War Item not Found", "Not a valid Type");
		}

			
	}

	@RequestMapping(value="/api/{type}/",produces=MediaType.APPLICATION_JSON_VALUE)
	public StarWarResponse getStarWarDataByName(@RequestParam(name = "search") String name, @PathVariable("type") String type) {


		if(type.equals("planet"))
		{
			StarWarResponse planetDataByName = planetService.getDataByName(name);

			return planetDataByName;
		}
		if(type.equals("film"))
		{
			StarWarResponse filmDataByName = filmService.getDataByName(name);
			return filmDataByName;
		}
		if(type.equals("people"))
		{
			StarWarResponse peopleDataById = peopleService.getDataByName(name);

			return peopleDataById;
		}

		else {
			throw new InvalidEndpointRequestException("Star War Item not Found", "Not a valid Type");
		}

	}
	


		public String getDefaultUser(Exception e)
		{
			return "Service Not Available" ;
		}
	
		public String getDefaultUser2(Exception e)

		{
			return "Service Not Available" ;
		}


		@Bean
		public RestTemplate restTemplate()
		{
		   return new RestTemplate();
		}
	

}

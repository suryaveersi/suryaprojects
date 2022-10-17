package com.starwar.api.controller;


import java.util.List;
import java.util.stream.Collectors;

import com.starwar.api.dto.FilmResponse;
import com.starwar.api.dto.PeopleResponse;
import com.starwar.api.dto.PlanetResponse;
import com.starwar.api.dto.StarWarResponse;
import com.starwar.api.model.Film;
import com.starwar.api.model.People;
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
import com.starwar.api.model.Planet;
import com.starwar.api.model.Type;

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
	@CircuitBreaker(name="StarWarService", fallbackMethod = "getdefaultuser")
	public List<StarWarResponse> getAllDataByType(@PathVariable("type") String type)
	{

		if(type.equals("planet"))
		{
			List<StarWarResponse> planetResponses = planetService.getPlanetAllData();
			return planetResponses;
		}

		if(type.equals("film"))
		{
			List<StarWarResponse> filmResponses = filmService.getFilmAllData();
			return filmResponses;
		}

		if(type.equals("people"))
		{
			List<StarWarResponse> peopleResponses = peopleService.getPeopleAllData();
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
			StarWarResponse planetResponse = planetService.getDataById(id);

			return planetResponse;
		}
		if(type.equals("film"))
		{
			StarWarResponse filmdatabyid = filmService.getDataById(id);

			return filmdatabyid;
		}

		if(type.equals("people"))
		{
			StarWarResponse peopledatabyid = peopleService.getDataById(id);

			return peopledatabyid;
		}

		else {
			throw new InvalidEndpointRequestException("Star War Item not Found", "Not a valid Type");
		}

			
	}

	@RequestMapping(value="/api/{type}/",produces=MediaType.APPLICATION_JSON_VALUE)
	public StarWarResponse getStarWarDataByName(@RequestParam(name = "search") String name, @PathVariable("type") String type) {


		if(type.equals("planet"))
		{
			StarWarResponse planetdatabyname = planetService.getDataByName(name);

			return planetdatabyname;
		}
		if(type.equals("film"))
		{
			StarWarResponse filmdatabyname = filmService.getDataByName(name);
			return filmdatabyname;
		}
		if(type.equals("people"))
		{
			StarWarResponse peopledatabyid = peopleService.getDataByName(name);

			return peopledatabyid;
		}

		else {
			throw new InvalidEndpointRequestException("Star War Item not Found", "Not a valid Type");
		}

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

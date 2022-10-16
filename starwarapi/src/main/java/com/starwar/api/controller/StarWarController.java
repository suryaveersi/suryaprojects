package com.starwar.api.controller;


import java.util.List;
import java.util.stream.Collectors;

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
	private Object collect;



	@GetMapping(value="/api/{type}",produces=MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name="StarWarService", fallbackMethod = "getdefaultuser")
	public List<Planet> getAllDataByType(@PathVariable("type") String type)
	{

		if(type.equals("planet"))
		{
			List<Planet> obj = planetService.getPlanetAllData();
			List<String> urls = obj.stream().map(i-> i.getFilms().stream().map(j-> j.getUrl()).collect(Collectors.toList()))
					.collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toList());
		    System.out.println(urls);


			System.out.println("hi");
			return obj;
		}
		else {
			throw new InvalidEndpointRequestException("Star War Item not Found", "Not a valid Type");
		}
			
	}
	
	@RequestMapping(value="/api/{type}/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Type getStarWarDataById(@PathVariable("type") String type,@PathVariable("id") Integer id)
	{

		if(type.equals("planet"))
		{
			Planet planetdatabyid = planetService.getPlanetDataById(id);

			return planetdatabyid;
		}
		if(type.equals("film"))
		{
			Film filmdatabyid = filmService.geFilmDataById(id);

			return filmdatabyid;
		}

		if(type.equals("people"))
		{
			People peopledatabyid = peopleService.gePeopleDataById(id);

			return peopledatabyid;
		}

		else {
			throw new InvalidEndpointRequestException("Star War Item not Found", "Not a valid Type");
		}

			
	}

	@RequestMapping(value="/api/{type}/",produces=MediaType.APPLICATION_JSON_VALUE)
	public Type getStarWarDataByName(@RequestParam(name = "search") String name, @PathVariable("type") String type) {


		if(type.equals("planet"))
		{
			Planet planetdatabyname = planetService.getPlanetDataByName(name);

			return planetdatabyname;
		}
		if(type.equals("film"))
		{
			Film filmdatabyname = filmService.getFilmDataByName(name);
			return filmdatabyname;
		}
		if(type.equals("people"))
		{
			People peopledatabyid = peopleService.getPeopleDataByName(name);

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

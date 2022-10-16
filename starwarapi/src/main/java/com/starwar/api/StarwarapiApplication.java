package com.starwar.api;

import com.starwar.api.dao.FilmRepo;
import com.starwar.api.dao.PlanetRepo;
import com.starwar.api.model.Film;
import com.starwar.api.model.People;
import com.starwar.api.model.Planet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@ComponentScan(value="com.starwar.api")
public class StarwarapiApplication {



	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(StarwarapiApplication.class, args);
		PlanetRepo repo = context.getBean(PlanetRepo.class);
		FilmRepo filmrepo = context.getBean(FilmRepo.class);
		Planet planet = new Planet(1,"Mars","https://swapi.dev/api/planets/1/");
		repo.save(planet);
		Film film1 = new Film(1,"bhramstra",4,planet,"https://swapi.dev/api/films/1/");

       // List<Film> films = Arrays.asList(film1,film2);

		filmrepo.save(film1);
		planet.setFilm(film1);
		repo.save(planet);


		Planet planet1 = new Planet(2,"Jupitor","https://swapi.dev/api/planets/2/");
		repo.save(planet1);
		Film film2 = new Film(2,"bhramstra-1",3,planet1,"https://swapi.dev/api/films/2/");
		filmrepo.save(film2);
		planet1.setFilm(film2);
		repo.save(planet1);


		//People people1 = new People(1,"Luke Skywalker","1995", "Male", "https://swapi.dev/api/people/1/",planet);
	//	People people2 = new People(2,"Luke Skywalker-2","1996","Male","https://swapi.dev/api/people/2/", planet);
	//	List<People> peoples = Arrays.asList(people1,people2);
	//	planet.setFilms(films);
	//	planet.setPeoples(peoples);
	//	repo.save(planet);
	}


}

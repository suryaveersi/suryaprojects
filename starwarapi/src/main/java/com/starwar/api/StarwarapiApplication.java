package com.starwar.api;

import com.starwar.api.dao.FilmRepo;
import com.starwar.api.dao.PeopleRepo;
import com.starwar.api.dao.PlanetRepo;
import com.starwar.api.model.Film;
import com.starwar.api.model.People;
import com.starwar.api.model.Planet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@ComponentScan(value="com.starwar.api")
public class StarwarapiApplication {



	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(StarwarapiApplication.class, args);
		PlanetRepo repo = context.getBean(PlanetRepo.class);
		FilmRepo filmrepo = context.getBean(FilmRepo.class);
		PeopleRepo peopleRepo = context.getBean(PeopleRepo.class);

		//First planet data
		Planet planet = new Planet(1,"Mars","https://swapi.dev/api/planets/1/");
		repo.save(planet);

		People people1 = new People(1,"Luke Skywalker-1","1995", "Male", "https://swapi.dev/api/people/1/",planet,"https://swapi.dev/api/planets/1/");
		peopleRepo.save(people1);
		//First film data
		Film film1 = new Film(1,"bhramstra",4,planet,"https://swapi.dev/api/films/1/",people1);
		filmrepo.save(film1);
		planet.setFilm(film1);
		people1.setFilm(film1);
		repo.save(planet);
		peopleRepo.save(people1);

        //Second planet data
		Planet planet1 = new Planet(2,"Jupitor","https://swapi.dev/api/planets/2/");
		repo.save(planet1);
		//Second film data
		Film film2 = new Film(2,"bhramstra-1",3,planet,"https://swapi.dev/api/films/2/",people1);
		filmrepo.save(film2);

		planet1.setFilm(film1);
		people1.setFilm(film1);
		repo.save(planet1);
		peopleRepo.save(people1);


		People people2 = new People(2,"Luke Skywalker-2","1996","Male","https://swapi.dev/api/people/2/", planet,"https://swapi.dev/api/planets/1/");
		peopleRepo.save(people2);
		Film film3 = new Film(3,"bhramstra-3",4,planet1,"https://swapi.dev/api/films/3/",people2);
		filmrepo.save(film3);

		planet1.setFilm(film3);
		people2.setFilm(film2);
		repo.save(planet1);
		peopleRepo.save(people2);

		Film film4 = new Film(4,"bhramstra-4",5,planet1,"https://swapi.dev/api/films/4/",people2);
		filmrepo.save(film4);
		people2.setFilm(film4);
		peopleRepo.save(people2);



	}


}

package com.starwar.api.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Planet implements Type {
	
	String name; 
	String diameter; 
	String rotation_period; 
	String orbital_period; 
	String gravity ; 
	String population;
	String climate ;
	String terrain;
	String surface_water ;
	List<People> residents;
	List<Film> films;
	String url ;
	String created;
	String edited;

	public Planet(String name, String diameter, String rotation_period, String orbital_period, String gravity,
			String population, String climate, String terrain, String surface_water, List<People> residents,
			List<Film> films, String url, String created, String edited) {
		
		this.name = name;
		this.diameter = diameter;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.gravity = gravity;
		this.population = population;
		this.climate = climate;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.residents = residents;
		this.films = films;
		this.url = url;
		this.created = created;
		this.edited = edited;
	}
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
 public List<Type> data()
 {
	 List<Type> list = new ArrayList<Type>();
	 People resi1 = new People();
	 People resi2 = new People();
	 Film film1 = new Film();
	 Film film2 = new Film();
	 List<People> residentlist = new ArrayList<>();
	 List<Film> filmlist = new ArrayList<>();
	 residentlist.add(resi1);
	 filmlist.add(film1);
	 residentlist.add(resi2);
	 filmlist.add(film2);
	 
	 list.add(new Planet("Tatooine", "10465", "23", "304", "1", "12000", "Arid", "Dessert", "1", residentlist, filmlist, 
			 "https://swapi.dev/api/planets/1/", "2014-12-09T13:50:49.641000Z", "2014-12-15T13:48:16.167217Z"));
	 list.add(new Planet("Tatooine", "10465", "23", "304", "1", "12000", "Arid", "Dessert", "1", residentlist, filmlist, 
			 "https://swapi.dev/api/planets/2/", "2014-12-09T13:50:49.641000Z", "2014-12-15T13:48:16.167217Z"));
	return list;
 }


}

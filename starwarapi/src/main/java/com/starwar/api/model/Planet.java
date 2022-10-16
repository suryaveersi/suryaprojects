package com.starwar.api.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Planet implements Type {

	@Id
    Integer planetid;
	String name;
	String url ;


	@OneToMany(mappedBy = "planet")
	@JsonManagedReference
	List<Film> films;

	@OneToMany(mappedBy = "planet")
	@JsonManagedReference
	List<People> peoples;


	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="film_id")
	Film film;


	public Planet(Integer planetid, String name, String url) {
		this.planetid = planetid;
		this.name = name;
		this.url = url;

	}


	/*@OneToMany(fetch = FetchType.EAGER, orphanRemoval = false, mappedBy = "planets")
	protected List<People> residents = new ArrayList<>();*/

	/*@OneToMany(targetEntity=People.class, mappedBy="planet", fetch= FetchType.LAZY)
	List<People> residents;
	@OneToMany(targetEntity=Film.class, mappedBy="planet", fetch= FetchType.LAZY)
	List<Film> films;*/


	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Type> data() {
		return null;
	}

/*
	public Planet data1() {
	Planet planet = new Planet();
	planet.setName("Mars");
	planet.setPlanetid(1);
	planet.setUrl("https://swapi.dev/api/planets/1/");



	planet.setFilms(listoffilm);

	return planet;*/



}


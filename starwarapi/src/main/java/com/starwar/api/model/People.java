package com.starwar.api.model;

import java.util.List;

public class People implements Type {

	String name ;
	String birth_year;
	String eye_color;
	String gender ;
	String hair_color ; 
	String height;
	String mass; 
	String skin_color; 
	String homeworld;
	List<Film> films ; 
	List<Species> species ; 
	List<Starships> starships; 
	List<Vehicals> vehicles; 
	String url ; 
	String created ;
	String edited ; 
	
	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBirth_year() {
		return birth_year;
	}



	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}



	public String getEye_color() {
		return eye_color;
	}



	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getHair_color() {
		return hair_color;
	}



	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}



	public String getHeight() {
		return height;
	}



	public void setHeight(String height) {
		this.height = height;
	}



	public String getMass() {
		return mass;
	}



	public void setMass(String mass) {
		this.mass = mass;
	}



	public String getSkin_color() {
		return skin_color;
	}



	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}



	public String getHomeworld() {
		return homeworld;
	}



	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}



	public List<Film> getFilms() {
		return films;
	}



	public void setFilms(List<Film> films) {
		this.films = films;
	}



	public List<Species> getSpecies() {
		return species;
	}



	public void setSpecies(List<Species> species) {
		this.species = species;
	}



	public List<Starships> getStarships() {
		return starships;
	}



	public void setStarships(List<Starships> starships) {
		this.starships = starships;
	}



	public List<Vehicals> getVehicles() {
		return vehicles;
	}



	public void setVehicles(List<Vehicals> vehicles) {
		this.vehicles = vehicles;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getCreated() {
		return created;
	}



	public void setCreated(String created) {
		this.created = created;
	}



	public String getEdited() {
		return edited;
	}



	public void setEdited(String edited) {
		this.edited = edited;
	}



	@Override
	public String toString() {
		return "Type [name=" + name + "]";
	}



	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Type> data() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

package com.starwar.api.model;

import java.util.List;

public class Starships {
	
	String name ;
	String model ;
	String starship_class ;
	String manufacturer; 
	String cost_in_credits; 
	String length ;
	String crew;
	String passengers;
	String max_atmosphering_speed;
	String hyperdrive_rating;
	String MGLT ;
	String cargo_capacity;
	String consumables ;
	
	List<Film> films;
	List<People> pilots;
	String url ;
	String created;
	String edited ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStarship_class() {
		return starship_class;
	}
	public void setStarship_class(String starship_class) {
		this.starship_class = starship_class;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCost_in_credits() {
		return cost_in_credits;
	}
	public void setCost_in_credits(String cost_in_credits) {
		this.cost_in_credits = cost_in_credits;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	public String getPassengers() {
		return passengers;
	}
	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}
	public String getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}
	public void setMax_atmosphering_speed(String max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}
	public String getHyperdrive_rating() {
		return hyperdrive_rating;
	}
	public void setHyperdrive_rating(String hyperdrive_rating) {
		this.hyperdrive_rating = hyperdrive_rating;
	}
	public String getMGLT() {
		return MGLT;
	}
	public void setMGLT(String mGLT) {
		MGLT = mGLT;
	}
	public String getCargo_capacity() {
		return cargo_capacity;
	}
	public void setCargo_capacity(String cargo_capacity) {
		this.cargo_capacity = cargo_capacity;
	}
	public String getConsumables() {
		return consumables;
	}
	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	public List<People> getPilots() {
		return pilots;
	}
	public void setPilots(List<People> pilots) {
		this.pilots = pilots;
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

	
}


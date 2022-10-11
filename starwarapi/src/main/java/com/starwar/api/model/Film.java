package com.starwar.api.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Film implements Type {
	
	
	String title ;
	Integer episode_id ;
	String opening_crawl ;
	String director ;
	String producer ;
	Date release_date ;
	List<Species> Stringspecies ;
	List<Starships> starships ;
	List<Vehicals> vehicles ;
	List<People> characters;
	List<Planet> planets ;
	String url;
	String created ;
	String edited ;
	
	
	
	
	


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(Integer episode_id) {
		this.episode_id = episode_id;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public List<Species> getStringspecies() {
		return Stringspecies;
	}

	public void setStringspecies(List<Species> stringspecies) {
		Stringspecies = stringspecies;
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

	public List<People> getCharacters() {
		return characters;
	}

	public void setCharacters(List<People> characters) {
		this.characters = characters;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
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
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Type> data() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}

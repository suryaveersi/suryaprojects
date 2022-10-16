package com.starwar.api.model;

import java.util.Date;
import java.util.List;

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
@Table(name="film")
public class Film implements Type {

	@Id
	Integer filmid;
	String  title ;
	Integer episode_id ;

	String url;

	@OneToMany(mappedBy = "film")
	@JsonManagedReference
	List<Planet> planets;

	@OneToMany(mappedBy = "film")
	@JsonManagedReference
	List<People> peoples;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="planet_id")
	Planet planet;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="people_id")
	People people;

	public Film(Integer filmid, String title, Integer episode_id, Planet planet, String url,People people) {
		this.filmid = filmid;
		this.title = title;
		this.episode_id = episode_id;
		this.planet = planet;
		this.url = url;
		this.people = people;
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

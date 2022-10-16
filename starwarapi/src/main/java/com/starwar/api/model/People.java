package com.starwar.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="people")
public class People implements Type {

	@Id
	Integer peopleid;
	String name ;
	String birth_year;
	String gender ;
	String url ;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="planet_id")
	Planet planet;


	public People(Integer peopleid, String name, String birth_year, String gender, String url, Planet planet ) {
		this.peopleid = peopleid;
		this.name = name;
		this.birth_year = birth_year;
		this.gender = gender;
		this.url = url;

		this.planet = planet;
		this.url = url;
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

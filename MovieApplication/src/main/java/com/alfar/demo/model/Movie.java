package com.alfar.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Movies")
public class Movie {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name ="language_movie",joinColumns = {@JoinColumn(name = "movie_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "language_id",referencedColumnName = "id")})
	private List<Language> language;
	
	public Movie() {}
	
	
	public Movie(Integer id, String name, List<Language> language) {
		
		this.id = id;
		this.name = name;
		this.language = language;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Language> getLanguage() {
		return language;
	}


	public void setLanguage(List<Language> language) {
		this.language = language;
	}
	
	
	

}

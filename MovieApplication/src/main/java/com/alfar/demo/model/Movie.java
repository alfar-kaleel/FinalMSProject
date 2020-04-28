package com.alfar.demo.model;

import java.io.Serializable;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "movies")
public class Movie implements Serializable{
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name ="language_movie",joinColumns = {@JoinColumn(name = "movie_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "language_id",referencedColumnName = "id")})
	private List<Language> language;
	
	@Lob
	private byte[] image;
	
	public Movie() {}
	
	
	public Movie(Integer id, String name, List<Language> language, byte[] image) {
		
		this.id = id;
		this.name = name;
		this.language = language;
		this.image = image;
		
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


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	

}

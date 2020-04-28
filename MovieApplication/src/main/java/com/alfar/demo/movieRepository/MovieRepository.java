package com.alfar.demo.movieRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alfar.demo.model.Language;
import com.alfar.demo.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	//@Query(value = "SELECT * FROM movies m WHERE m.languages.name = ?1", nativeQuery = true)
	//List <Movie> findByLanguage(Language language );
	

}

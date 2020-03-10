package com.alfar.demo.movieRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alfar.demo.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	
	

}

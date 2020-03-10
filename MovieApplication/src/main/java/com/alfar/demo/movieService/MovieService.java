package com.alfar.demo.movieService;

import java.util.List;

import com.alfar.demo.model.Movie;

public interface MovieService {
	
	
	List<Movie> findAllMovies(); 
	
	Movie saveMovie(Movie movie); 
	
	void deleteMovieById(int movieId);

}

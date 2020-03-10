package com.alfar.demo.movieController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alfar.demo.model.Movie;
import com.alfar.demo.movieService.MovieService;

@RestController
@RequestMapping(value = "/Movie")
public class MovieController {

	@Autowired
   MovieService movieService;
	
	@RequestMapping(value = "/findAllMovies" , method = RequestMethod.GET )
	List<Movie> fetchAllmovies(){
		
		
		return movieService.findAllMovies();
		
	}
	
	@RequestMapping(value = "insertMovie" ,method = RequestMethod.POST)
	Movie insertMovie(@RequestBody Movie movie) {
		
		
		return movieService.saveMovie(movie);
	}
	
	
	
	@RequestMapping(value = "deleteMovie/{id}" , method = RequestMethod.DELETE)
	void deleteMovie(@PathVariable int id) throws EmptyResultDataAccessException{
		
		movieService.deleteMovieById(id);
		
	}
	
	
}

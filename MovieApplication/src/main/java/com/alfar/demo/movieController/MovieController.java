package com.alfar.demo.movieController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alfar.demo.model.Movie;
import com.alfar.demo.movieService.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/Movie")
public class MovieController {

	@Autowired
   MovieService movieService;
	
	@RequestMapping(value = "/findAllMovies" , method = RequestMethod.GET )
	List<Movie> fetchAllmovies(){
		
		
		return movieService.findAllMovies();
		
	}
	
	@RequestMapping(value = "/insertMovie" ,method = RequestMethod.POST)
	Movie insertMovie(@RequestParam("image") MultipartFile imageMPF,@RequestParam("movies") String movie) throws IOException {
		
		Movie addMovie = new ObjectMapper().readValue(movie,Movie.class);
		
		
		addMovie.setImage(imageMPF.getBytes());
		
		return movieService.saveMovie(addMovie);
		
	}
	
	/*
	@RequestMapping(value = "/findMoviebyLanguage/{language}", method = RequestMethod.GET)
	List <Movie> moviebyLanguage(@PathVariable String language){
		
		return movieService.findMoviebyLanguage(language);
		
	}
	*/
	
	@RequestMapping(value = "deleteMovie/{id}" , method = RequestMethod.DELETE)
	void deleteMovie(@PathVariable int id) throws EmptyResultDataAccessException{
		
		movieService.deleteMovieById(id);
		
	}
	
	
}

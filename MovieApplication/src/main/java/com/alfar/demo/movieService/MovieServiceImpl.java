package com.alfar.demo.movieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfar.demo.model.Movie;
import com.alfar.demo.movieRepository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository MovieRepo;

	@Override
	public List<Movie> findAllMovies() {
		
		return MovieRepo.findAll();
	}

	@Override
	public Movie saveMovie(Movie movie) {
		
		return MovieRepo.save(movie);
	}

	@Override
	public void deleteMovieById(int movieId) {
		
		MovieRepo.deleteById(movieId);
	}
	
	
	
	
	

}

package com.alfar.demo.movieService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	/*
	@Override
	public List<Movie> findMoviebyLanguage(String language) {
		
		return MovieRepo.findByLanguage(language);
	}
	*/
	

	
	
	

}

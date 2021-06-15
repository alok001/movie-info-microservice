package com.infinite.movieinfoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.movieinfoservice.model.Movie;
import com.infinite.movieinfoservice.repository.MovieRepository;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieRepository movieRepo;
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public List<Movie> getMovies()
	{
		
		return movieRepo.findAll();
	}
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Movie getMovie(@PathVariable Integer id)
	{
		
		return movieRepo.findById(id).get();
	}
	
	@RequestMapping(path="/",method=RequestMethod.POST)
	public Movie addMovie(@RequestBody Movie movie)
	{
		movieRepo.save(movie);
		
		return movie;
	}
	
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public ResponseEntity<String> addMovieList(@RequestBody List<Movie> movie)
	{
		movieRepo.saveAll(movie);
		
		//return movie;
		return new ResponseEntity<String>(" Movie list created succesfuly", HttpStatus.CREATED);
	}
	
	
}

package com.example.java;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	// Get All Employees
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable("movieId") int movieId) {
    	Movie movie = movieRepository.findById(movieId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid movie id :" + movieId));
    	return movie;
    }
    
    // Add a new movie
    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public Movie addMovie(@Valid @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    //update a movie
    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.PUT)
    public void updateMovie(@PathVariable("movieId") int movieId,@Valid @RequestBody Movie movie) {
    	movie.setMovieId(movieId);
    	movieRepository.save(movie);
    }
    //delete a movie
    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable("movieId") int movieId) {
    	Movie movie = movieRepository.findById(movieId)
    			.orElseThrow(() -> new IllegalArgumentException("Invalid movie id :" + movieId));
    	movieRepository.delete(movie);
    }
}

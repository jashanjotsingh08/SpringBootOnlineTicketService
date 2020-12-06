package com.example.java;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	String[] movieLanguageList = {"English","French","Punjabi","Hindi"};
	String[] movieGenreList = {"Action","Drama","Romance","Horror","Comedy"};

	@RequestMapping("/")
	public ModelAndView home() {
		return index();
	}

	@GetMapping(value = { "/", "/index" })
	public ModelAndView index() {
		List<Movie> movies = movieRepository.findAll();
		ModelAndView model = new ModelAndView();
		model.addObject("movies", movies);
		model.addObject("title", "Home-Page");
		model.setViewName("index");
		return model;
	}

	@GetMapping("movies/{id}")
	public String getMovie(@PathVariable("id") int movieId, Model model) {
		Movie movie = movieRepository.getOne(movieId);
		if (movie != null) {
			model.addAttribute("movie", movie);
			model.addAttribute("movieId", movieId);
			return "movie-details";
		} else {
			return "error";
		}
	}

	@GetMapping(value = "/addMovieForm")
	public String addMovieForm(Movie movie,Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("genreList", movieGenreList);
		model.addAttribute("languageList", movieLanguageList);
		model.addAttribute("title", "Add-Movie");
		return "add-movie";
	}

	@PostMapping(value = "/addMovie")
	public ModelAndView addMovie(@Valid Movie movie, BindingResult result, ModelAndView model) {
		if (result.hasErrors()) {
			model.addObject("movie",movie);
			model.setViewName("add-movie");
			return model;
		}
		try {
			movieRepository.save(movie);
			return index();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String messageString = e.getMessage();
			model.addObject("message", messageString);
			model.setViewName("add-movie");
			return model;
		}
	}

	@GetMapping("/update/{id}")
	public String updateMoviePage(@PathVariable("id") int movieId, Model model) {

		model.addAttribute("movie", movieRepository.getOne(movieId));
		model.addAttribute("movieId", movieId);
		model.addAttribute("title", "Update Movie");
		return "update-movie";
	}

	@RequestMapping(value = "/updateMovie/{id}", consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView updateMovie(@PathVariable("id") int movieId,@Valid @ModelAttribute("movie") Movie movie,
			UriComponentsBuilder uriBuilder, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return index();
		}
		movie.setMovieId(movieId);
		movieRepository.save(movie);

		return index();
	}

	@GetMapping(value = "/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView deleteMovie(@PathVariable("id") int movieId) throws Exception {
		movieRepository.deleteById(movieId);
		return index();
	}
}

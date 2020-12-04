package com.example.java;

import java.security.interfaces.DSAPrivateKey;
import java.sql.Time;
import java.time.Duration;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "movies")
public class Movie {

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	
	@NotBlank(message = "Please enter time of the movie")
	@Column(name = "duration")
	private String duration;
	
	@NotBlank(message = "Please enter genre of the movie")
	@Column(name = "movie_genre")
	private String movieGenre;
	
	@NotBlank(message = "Please select language of the movie")
	@Column(name = "movie_language")
	private String movieLanguage;

	@NotBlank(message = "Please enter name of the movie")
	@Column(name = "movie_name")
	private String movieName;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}

package com.example.java;

import java.security.interfaces.DSAPrivateKey;
import java.time.Duration;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

	public Movie(int movieId, Duration duration, String movieGenre, String movieLanguage, String movieName) {
		this.movieId = movieId;
		this.duration = duration;
		this.movieGenre = movieGenre;
		this.movieLanguage = movieLanguage;
		this.movieName = movieName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	@NotNull
	@Past
	@Column(name = "duration")
	private Duration duration;
	
	@NotNull
	@Column(name = "movie_genre")
	private String movieGenre;
	
	@NotNull
	@Column(name = "movie_language")
	private String movieLanguage;

	@NotNull
	@Column(name = "movie_name")
	private String movieName;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
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

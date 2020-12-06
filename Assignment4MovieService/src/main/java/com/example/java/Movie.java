package com.example.java;

import java.security.interfaces.DSAPrivateKey;
import java.sql.Time;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converts;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.validation.annotation.Validated;
import org.thymeleaf.templatemode.TemplateMode;

@Entity
@Table(name = "movies")
public class Movie {

	public Movie(int movieId, @PastOrPresent(message = "Please follow the pattern HH:mm") Date duration,
			@NotNull @NotBlank(message = "Please enter genre of the movie") String movieGenre,
			@NotNull @NotBlank(message = "Please select language of the movie") String movieLanguage,
			@NotNull @NotBlank(message = "Please enter name of the movie") String movieName) {
		this.movieId = movieId;
		this.duration = duration;
		this.movieGenre = movieGenre;
		this.movieLanguage = movieLanguage;
		this.movieName = movieName;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	@PastOrPresent(message = "Please follow the pattern HH:mm")
	@Column(name = "duration")
	private Date duration;
	
	@NotNull
	@NotBlank(message = "Please enter genre of the movie")
	@Column(name = "movie_genre")
	private String movieGenre;
	
	@NotNull
	@NotBlank(message = "Please select language of the movie")
	@Column(name = "movie_language")
	private String movieLanguage;

	@NotNull
	@NotBlank(message = "Please enter name of the movie")
	@Column(name = "movie_name")
	private String movieName;

	

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", duration=" + duration + ", movieGenre=" + movieGenre
				+ ", movieLanguage=" + movieLanguage + ", movieName=" + movieName + "]";
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
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

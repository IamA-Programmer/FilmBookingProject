package com.bus.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "moviesdetails")
public class MovieDetails {
	
	@Id
	@GenericGenerator(name = "ref",strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name="movieid")
	private long movieId;
	
	@Column(name="moviename")
	private String movieName;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "moviedetails")
	private String movietype;
	

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getMovietype() {
		return movietype;
	}

	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}

	public MovieDetails(long movieId, String movieName, String image,String movietype) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.image = image;
		this.movietype=movietype;
		
	}

	public MovieDetails(String movieName, String image,String movietype) {
		super();
		this.movieName = movieName;
		this.image = image;
		this.movietype=movietype;
		
	}

	public MovieDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MovieDetails [movieId=" + movieId + ", movieName=" + movieName + ", image=" + image + ", movieDetails="
				 + "]";
	}
}

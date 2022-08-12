package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;

public class MovieFullDTO extends MovieDTO {
	private static final long serialVersionUID = 1L;
	
	private GenreDTO genre;
	
	public MovieFullDTO() {
	}
	
	public MovieFullDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis,
			GenreDTO genre) {
		super(id, title, subTitle, year, imgUrl, synopsis);
		this.genre = genre;
	}
	
	public MovieFullDTO(Movie movie) {
		super(movie);
		this.genre = new GenreDTO(movie.getGenre());
	}

	public GenreDTO getGenre() {
		return genre;
	}
	
	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}
}

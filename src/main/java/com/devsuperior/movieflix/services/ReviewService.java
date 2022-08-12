package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewDetailDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private MovieRepository movieRepository; 
	
	@Transactional
	public ReviewDetailDTO insert(ReviewDTO dto) {
		
		//Recupera usuário autenticado
		User user = authService.authenticated();
		
		//Recupera filme
		Movie movie = movieRepository.getOne(dto.getMovieId());
		
		Review review = new Review();
		review.setText(dto.getText());
		review.setUser(user);
		review.setMovie(movie);
		
		review = repository.save(review);
		
		
		return new ReviewDetailDTO(review);
	}

}

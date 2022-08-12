package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.dto.ReviewDetailDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT obj FROM Movie obj INNER JOIN obj.genre " 
			+ "WHERE (COALESCE(:genre) IS NULL OR obj.genre IN :genre )")
	Page<Movie> find(Genre genre, Pageable pageable);
	
	@Query("SELECT new com.devsuperior.movieflix.dto.ReviewDetailDTO(obj.id, obj.text, obj.movie.id, obj.user.id, obj.user.name, obj.user.email) "
			+ "FROM Review obj "
			+ "WHERE obj.movie.id= :id")
	List<ReviewDetailDTO> findMovieReview(Long id);
	
}

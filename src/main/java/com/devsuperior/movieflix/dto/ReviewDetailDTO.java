package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDetailDTO extends ReviewDTO {
	private static final long serialVersionUID = 1L;
	
	private UserDTO user;

	public ReviewDetailDTO(Long id, String text, Long movieId, UserDTO user) {
		super(id, text, movieId);
		this.user = user;
	}
	
	public ReviewDetailDTO(Long id, String text, Long movieId, Long userId, String userName, String userEmail) {
		super(id, text, movieId);
		this.user = new UserDTO(userId, userName, userEmail);
	}
	
	public ReviewDetailDTO(Review review) {
		super(review.getId(), review.getText(), review.getMovie().getId());
		this.user = new UserDTO(review.getUser());
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}

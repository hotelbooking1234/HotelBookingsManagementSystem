package com.cg.hbm.util.review;


import org.springframework.stereotype.Component;

import com.cg.hbm.dto.review.ReviewDTO;
import com.cg.hbm.dto.review.ReviewResponseDTO;
import com.cg.hbm.entites.Review;

@Component
public class ReviewDTOConvertor {
	
	public ReviewResponseDTO getReviewResponseDTO(Review review)
	{
		ReviewResponseDTO dto = new ReviewResponseDTO();
		
		dto.setReveiwId(review.getReviewId());
		dto.setUserName(review.getUserName());
		dto.setStarRating(review.getStarRating());
		dto.setHotelId(review.getHotelId());
		dto.setRoomId(review.getRoomId());
		dto.setMsg("review saved");
		return dto;
		
	}
	public ReviewDTO getReviewDTO(Review r) {
		
		
		ReviewDTO obj = new ReviewDTO(r.getReviewId(),r.getUserName(),r.getUserReviewMsge(),r.getStarRating(),r.getHotelId(),r.getRoomId());
				
		return obj;
		
	}
	public ReviewResponseDTO convertTo(Review review) {
		// TODO Auto-generated method stub
		return null;
	}

}

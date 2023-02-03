package com.cg.hbm.service.review;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.entites.Review;
import com.cg.hbm.exceptions.review.InvalidInputDataException;


@Service
public interface ReviewService {
	
	
	    public List<Review> getAllReviews();
	    public Review addReview(Review review) throws Exception;
	 	
		public List<Review> getReviewByHotelId(int hotelId) throws InvalidInputDataException;

		public List<Review> getReviewByRoomId(int roomId) throws InvalidInputDataException;
		
		public List<Review> getReviewByStarRating(int starRating);
		
		
}



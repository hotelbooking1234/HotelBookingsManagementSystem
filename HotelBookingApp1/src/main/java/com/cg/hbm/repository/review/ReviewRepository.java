package com.cg.hbm.repository.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hbm.entites.Review;
import com.cg.hbm.exceptions.review.InvalidInputDataException;

public interface ReviewRepository extends JpaRepository<Review,Integer>{

	List<Review> getReviewByStarRating(int starRating);	
	
	List<Review> getReviewByHotelId(int hotelId) throws InvalidInputDataException;
	
	List<Review> getReviewByRoomId(int roomId) throws InvalidInputDataException;

	
}

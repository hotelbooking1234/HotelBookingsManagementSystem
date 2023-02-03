package com.cg.hbm.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Review {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	
	private int reviewId;
	
	private int hotelId;
	private LocalDate reviewDate;
	private int roomId;
	private String userName;
	private String userReviewMsge;
	private int starRating;
	private boolean verifiedStatus;
	
	public Review(int hotelId, LocalDate reviewDate, int roomId, String userName, String userReviewMsge, int starRating,
			boolean verifiedStatus) {
		super();
		this.hotelId = hotelId;
		this.reviewDate = reviewDate;
		this.roomId = roomId;
		this.userName = userName;
		this.userReviewMsge = userReviewMsge;
		this.starRating = starRating;
		this.verifiedStatus = verifiedStatus;
	}

	
	
	
	
}

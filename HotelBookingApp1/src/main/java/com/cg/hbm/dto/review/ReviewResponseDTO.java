package com.cg.hbm.dto.review;

import lombok.Data;

@Data
public class ReviewResponseDTO {
	private int reveiwId;
	
	
	private String userName;
	private int starRating;
	private int hotelId;
	private int roomId;
	private String msg;
		
	}




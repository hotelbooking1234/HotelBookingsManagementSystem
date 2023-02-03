package com.booking.app.service.review;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.hbm.entites.Review;
import com.cg.hbm.repository.review.ReviewRepository;
import com.cg.hbm.service.review.ReviewServiceImpl;

public class ReviewServiceImplTest {
	@InjectMocks   // use on which class to test
	ReviewServiceImpl reviewServiceImpl;
	
	@Mock
	ReviewRepository reviewRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void doInit()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Test case to test insertion of Course when input values are valid")
	void testAddReview() {
		// sample input 
		Review sampleInput = new Review(3 ,LocalDate.of(2023,01,01),1 ,"praveena","good accomodation",4,true);
		// expected output 
		Review actualOutput = new Review(3 ,LocalDate.of(2023,01,01),1 ,"praveena","good accomodation",4,true);
		actualOutput.setReviewId(0);
		actualOutput.setHotelId((Integer) null);
		
		
		Review expectedOutput = new Review(3 ,LocalDate.of(2023,01,01),1 ,"praveena","good accomodation",4,true);
		expectedOutput.setReviewId(0);
		expectedOutput.setHotelId((Integer) null);
		
		// call actual method and store actual result : actual output
		
		when(reviewRepository.save(sampleInput)).thenReturn(actualOutput);
		
			
		// compare actual output with expected output
		assertEquals(actualOutput, expectedOutput);
		
	}


	@Test
	@DisplayName("Test case to test insertion of Course when input values are invalid")
	void testAddCourse2() {
		Review sampleInput = new Review(3 ,LocalDate.of(2023,01,01),1 ,"praveena","good accomodation",4,true);
		
		// call actual method and store actual result : actual output
		
		when(reviewRepository.save(sampleInput)).thenThrow(NullPointerException.class);
		
		
	}

	
	
}





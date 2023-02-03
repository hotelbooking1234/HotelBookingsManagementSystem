/*package com.cg.hbm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.repository.IBookingDetailsRepository;
 

 
class BookingDetailsImplTest {
 
    @InjectMocks   // use on which class to test
    BookingDetailsImpl  bookingDetailsImpl;
    
    @Mock
    IBookingDetailsRepository iBookingDetailsRepository;
    
    @SuppressWarnings("deprecation")
    @BeforeEach
    public void doInit()
    {
         MockitoAnnotations.initMocks(this);
    }
    
    @Test
    @DisplayName("Test case to test insertion of Booking when input values are valid")
    void testAddCourse() {
         // sample input 
         BookingDetails sampleInput = new BookingDetails(1, 20, 4,9,Date.of(1970,01,01T00:00:00,009+00:00),9,8,7.8);
         // expected output 
         BookingDetails actualOutput = new BookingDetails(, 20, 4,9,"Programming","Pooja Thakur",9,8,7.8);
         actualOutput.setBookingId(0);
        // actualOutput.setBookings(null);
         
         
         BookingDetails expectedOutput = new BookingDetails(1, 20, 4,9,Date.from(2001,07,05),9,8,7.8);
         expectedOutput.setBookingId(0);
        // expectedOutput.setBookings(null);
         
         // call actual method and store actual result : actual output
         
     when(iBookingDetailsRepository.save(sampleInput)).thenReturn(actualOutput);
         
             
         // compare actual output with expected output
         assertEquals(actualOutput, expectedOutput);
         
    }
 
    
    
    
    
    @Test
    @DisplayName("Test case to test insertion of Course when input values are invalid")
    void testAddCourse2() {
         BookingDetails sampleInput = new BookingDetails(null, 20, "Programming","Pooja Thakur");
         
         // call actual method and store actual result : actual output
         
     when(iBookingDetailsRepository.save(sampleInput)).thenThrow(NullPointerException.class);
         
         
    }
 
    
   
}
*/


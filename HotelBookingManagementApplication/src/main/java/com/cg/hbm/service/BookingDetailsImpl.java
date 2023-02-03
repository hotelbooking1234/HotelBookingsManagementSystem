package com.cg.hbm.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.exceptions.InvalidInputException;
import com.cg.hbm.repository.IBookingDetailsRepository;

@Service
public class BookingDetailsImpl implements IBookingDetailsService {
	
	@Autowired 
	IBookingDetailsRepository bookingRepo;

	@Override
	
	public BookingDetails addBookingDetails(BookingDetails bookingDetails) throws InvalidInputException {
		// TODO Auto-generated method stub
		
		BookingDetails saveBookingDetails=bookingRepo.save(bookingDetails);
		if(saveBookingDetails!=null) {
			return saveBookingDetails;
			
		}
		else {
			throw new InvalidInputException("Booking Details not Found");
		}
		
	}

	@Override
	public BookingDetails updateBookingDetails(int bookingId) throws InvalidInputException {
		// TODO Auto-generated method stub
		BookingDetails upBookingDetails=bookingRepo.getReferenceById(bookingId);
		bookingRepo.save(upBookingDetails);
		return upBookingDetails;

		
		
		
		
	}

	@Override
	public BookingDetails deleteBookingDetails(int bookingId) throws InvalidInputException {
		// TODO Auto-generated method stub
	      BookingDetails exsistingBookingDetails=bookingRepo.findById(bookingId).orElseThrow(() -> new InvalidInputException("Booking is not listed"+bookingId));

	        bookingRepo.delete(exsistingBookingDetails);
	        return exsistingBookingDetails;


		
		
		
		
		
	}

	@Override
	public List<BookingDetails> getAllBookingDetails() throws InvalidInputException {
		
		
		
		
		
        List<BookingDetails> bookings=bookingRepo.findAll();
        if(bookings.size()>0) {
            return bookings;
        }
        else {
            throw new InvalidInputException("No detail found");
        }

    
 


		// TODO Auto-generated method stub
		
	}

	@Override
	public BookingDetails getBookingDetailsBybookingId(int bookingId) throws InvalidInputException
	
	
	
	{
		
		
		Optional<BookingDetails> getBookingDetailsBybookingId =bookingRepo.findById(null);
        if(getBookingDetailsBybookingId.isPresent()) {
            return getBookingDetailsBybookingId .get();
        }
        else {
            throw new InvalidInputException("No booking is found");
        }
    }
}

	
	



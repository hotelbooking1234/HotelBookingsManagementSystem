package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.exceptions.InvalidInputException;
@Service
public interface IBookingDetailsService {
	public BookingDetails addBookingDetails(BookingDetails bookingDetails) throws InvalidInputException;
	public BookingDetails updateBookingDetails(int bookingId)throws InvalidInputException;
	public BookingDetails deleteBookingDetails(int bookingId)throws InvalidInputException;
	public List<BookingDetails> getAllBookingDetails()throws InvalidInputException;
	public BookingDetails getBookingDetailsBybookingId(int bookingId) throws InvalidInputException;
}

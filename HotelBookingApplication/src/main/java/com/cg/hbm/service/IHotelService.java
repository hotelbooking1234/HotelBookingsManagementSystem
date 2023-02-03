
package com.cg.hbm.service;



import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.exception.RecordNotFoundException;

@Service

public interface IHotelService {
	
	public Hotel addHotel(Hotel hotel);
	
	public Hotel updateRoomByHotelId(int hId,int rId)  ;

	public List<Hotel> showAllHotels()  throws RecordNotFoundException; 
	
	public Hotel getHotelById(int hotelId)  throws RecordNotFoundException ;

	

	public Hotel deleteHotel(int hotelId) throws RecordNotFoundException;

	
	
}

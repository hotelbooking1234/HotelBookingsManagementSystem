package com.cg.hbm.service;

import java.util.ArrayList;
import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.entity.RoomDetails;
import com.cg.hbm.exception.RecordNotFoundException;

import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.repository.IRoomDetailsRepository;


@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository hotelRepository;
	
	@Autowired
	private IRoomDetailsRepository roomDetailsRepository;

@Override
	
	public Hotel addHotel(Hotel hotel) {

		Hotel savedHotel = hotelRepository.save(hotel);
		
		return savedHotel; 
	}

	
	public Hotel updateRoomByHotelId(int hotelId,int roomId)  {
		
		Hotel hotelFromDB=hotelRepository.getReferenceById(hotelId);
		RoomDetails roomFromDB=roomDetailsRepository.getReferenceById(roomId);
		if(hotelFromDB!=null &&roomFromDB!=null) {
			
			List<RoomDetails> allRooms=hotelFromDB.getRoomDetails();
			
			if(allRooms!=null&&allRooms.isEmpty()==false) {
				allRooms.add(roomFromDB);
				hotelFromDB.setRoomDetails(allRooms);
			}
			else
			{
				List<RoomDetails> freshRoomList=new ArrayList();
				freshRoomList.add(roomFromDB);
				hotelFromDB.setRoomDetails(freshRoomList);
			}
			hotelRepository.save(hotelFromDB);
			return hotelFromDB;
		}
		else 
		{
			return null;
		}

		
	}

	@Override
	
	public Hotel deleteHotel(int hotelId) throws RecordNotFoundException {

		Hotel exsistingHotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RecordNotFoundException("Hotel is not listed" + hotelId));

		hotelRepository.delete(exsistingHotel);
		return exsistingHotel;

	}

	@Override
	public Hotel getHotelById(int hotelId) throws RecordNotFoundException {

		//Optional<Hotel> viewHotel = hotelRepository.findById(hotelId);
		//if (viewHotel.isPresent()) {
			//return viewHotel.get();
		//} else {
			//throw new RecordNotFoundException("No hotel is found");
		//}
		
		if(hotelId>=1) {
			return hotelRepository.getReferenceById(hotelId);
		}
		return null;
	}

	@Override

	public List<Hotel> showAllHotels() throws RecordNotFoundException {

		List<Hotel> allHotels = hotelRepository.findAll();
		if (allHotels.size() > 0) {
			return allHotels;
		} else {
			throw new RecordNotFoundException("No hotel found");
		}

	}


	

	
}

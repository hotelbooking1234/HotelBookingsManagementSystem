package com.cg.hbm.controller;

import java.util.ArrayList;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.HotelAdminResponseDTO;
import com.cg.hbm.dto.HotelDTO;
import com.cg.hbm.entity.Hotel;
import com.cg.hbm.entity.RoomDetails;
import com.cg.hbm.exception.RecordNotFoundException;
import com.cg.hbm.repository.IRoomDetailsRepository;
//import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.service.IHotelService;
import com.cg.hbm.util.HotelDTOConvertor;


@RestController
@RequestMapping("/Hotel")
public class HotelRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IHotelService hotelService;
	
	
	@Autowired
	private IRoomDetailsRepository roomDetailsRepository;
	@Autowired
	private HotelDTOConvertor hotelDTOConvertor;
	
	public HotelRestController() {
		logger.info("Hotel booking Rest Controller called");
		System.err.println("Hotel booking Rest Controller called");
		}
	
	
	@PostMapping("/add")
	public ResponseEntity<HotelAdminResponseDTO> addHotel(@RequestBody Hotel hotel) {
		
		Hotel newHotel=hotelService.addHotel(hotel);
		HotelAdminResponseDTO dto=hotelDTOConvertor.getHotelAdminResponseDTO(newHotel);
		return new ResponseEntity<HotelAdminResponseDTO>(dto,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/{hid}/room/{rId}")
	public ResponseEntity<HotelAdminResponseDTO> updateRoomByHotelId(@RequestBody Hotel hotel,@PathVariable int hotelId,@PathVariable int roomId) {

		RoomDetails savedRoom=roomDetailsRepository.getReferenceById(roomId);
		Hotel updatedHotel = hotelService.updateRoomByHotelId(hotelId,roomId);
		if(updatedHotel!=null) {
		HotelAdminResponseDTO responseDTO = hotelDTOConvertor.getHotelAdminResponseDTO(updatedHotel);
		
		
       
		return new ResponseEntity<HotelAdminResponseDTO>(responseDTO, HttpStatus.OK);
		}
		return null;
		
        
	}
	
	@DeleteMapping("/delete/{hotelID}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable Integer hotelId) throws RecordNotFoundException {
       if(hotelId == null) {
    	   throw new RecordNotFoundException("No hotel exist with this id");
       }
       else {
		Hotel deletedHotel = hotelService.deleteHotel(hotelId);

		return new ResponseEntity<Hotel>(deletedHotel, HttpStatus.OK);
       }
         
	}

	@GetMapping("/get/{hotelID}")
	public ResponseEntity<HotelAdminResponseDTO> getHotelById(@PathVariable Integer hotelId) throws RecordNotFoundException {

		Hotel getHotel = hotelService.getHotelById(hotelId);
		HotelAdminResponseDTO getDTO = hotelDTOConvertor.getHotelAdminResponseDTO(getHotel);

		return new ResponseEntity<HotelAdminResponseDTO>(getDTO, HttpStatus.OK);
	}
	
	@GetMapping("/hotels")
	public ResponseEntity<List<HotelDTO>> showAllHotels() throws RecordNotFoundException {
		
		List<Hotel> allHotels = hotelService.showAllHotels() ; 
		List<HotelDTO> allHotelsDTO = new ArrayList<>();
		
		for (Hotel hotel : allHotels) {
			
			allHotelsDTO.add(hotelDTOConvertor.getHotelDTO(hotel));
			
		}

		
		return new ResponseEntity<List<HotelDTO>>(allHotelsDTO,HttpStatus.OK);
		
	}
}
package com.cg.hbm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Hotel")
@Entity
@Data

@NoArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int hotelId;
	private String city;
	private String hotelName;
	private String address;
	private String description;
	private double avgRatePerDay;
	private String email;
	private String phone1;
	private String phone2;
	private String website;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="hotelId")
	private List<RoomDetails> roomDetails;



	public Hotel(String city, String hotelName, String address, String description, double avgRatePerDay, String email,
			String phone1, String phone2, String website) {
		super();
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerDay = avgRatePerDay;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
	}


}

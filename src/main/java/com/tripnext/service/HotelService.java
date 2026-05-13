package com.tripnext.service;

import java.util.List;

import com.tripnext.entity.Hotel;

public interface HotelService {
	
	Hotel addHotel(Hotel hotel);
	List<Hotel> addAllHotel(List<Hotel> hotel);
	List<Hotel> getAllHotel();
	List<Hotel> searchByLocation(String location);
	List<Hotel> searchByHotelName(String hotelName);
	Hotel getHotelById(Long id);
	void deleteHotel(Long id);
	Hotel updateHotel(Long id, Hotel hotel);
}

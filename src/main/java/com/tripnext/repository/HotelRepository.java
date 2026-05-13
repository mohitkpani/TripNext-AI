package com.tripnext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripnext.entity.Hotel;
import java.util.List;


public interface HotelRepository extends JpaRepository<Hotel, Long>{
	
	
	List<Hotel> findByHotelNameContaining(String hotelName);
	List<Hotel> findByLocationContainingIgnoreCase(String location);

}

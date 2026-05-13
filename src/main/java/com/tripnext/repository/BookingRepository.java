package com.tripnext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripnext.entity.Booking;
import com.tripnext.entity.User;


public interface BookingRepository extends JpaRepository<Booking, Long>{
		
		List<Booking> findByUser(User user);
		void deleteByHotel_Id(Long hotelId);
}

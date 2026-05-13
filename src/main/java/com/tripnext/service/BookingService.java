package com.tripnext.service;

import java.util.List;

import com.tripnext.entity.Booking;

public interface BookingService {
	
	 Booking bookHotel(Booking booking);
	 List<Booking> getUserBookings(Long userId);
	 void cancelBooking(Long id);
	 List<Booking> getAllBookings();

}

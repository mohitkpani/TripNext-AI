package com.tripnext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripnext.entity.Booking;
import com.tripnext.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	// BOOK HOTEL API
	@PostMapping("/book")
	public Booking bookHotel(@RequestBody Booking booking) {
		return bookingService.bookHotel(booking);
	}

	// GET USER BOOKING API
	@GetMapping("/user/{userId}")
	public List<Booking> getUserBookings(@PathVariable Long userId){
		return bookingService.getUserBookings(userId);
	}
	
	@DeleteMapping("/delete/{id}")
	public String cancelBooking(@PathVariable Long id){
	    bookingService.cancelBooking(id);
	    return "Booking Cancelled";
	}
	
	// GET ALL BOOKINGS
	@GetMapping("/all")
	public List<Booking> getAllBookings(){
	    return bookingService.getAllBookings();
	}
	
	@GetMapping("/revenue")
	public Double getTotalRevenue(){

	    List<Booking> bookings =
	    bookingService.getAllBookings();

	    double total = 0;

	    for(Booking booking : bookings){

	        total += booking
	        .getHotel()
	        .getPrice();
	    }

	    return total;
	}
}

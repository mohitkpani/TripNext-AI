package com.tripnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripnext.dto.AdminStatsDTO;
import com.tripnext.repository.BookingRepository;
import com.tripnext.repository.HotelRepository;
import com.tripnext.repository.PlaceRepository;
import com.tripnext.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/stats")
    public AdminStatsDTO getAdminStats(){

        long totalHotels =
        hotelRepo.count();

        long totalPlaces =
        placeRepository.count();

        long totalBookings =
        bookingRepo.count();

        long totalUsers =
        userRepo.count();

        double revenue = bookingRepo.findAll().stream().mapToDouble(booking -> booking.getHotel().getPrice()).sum();

        return new AdminStatsDTO(totalHotels,totalPlaces,totalBookings,totalUsers,revenue);
    }
}
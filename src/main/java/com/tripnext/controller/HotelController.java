package com.tripnext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripnext.entity.Hotel;
import com.tripnext.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // ADD HOTEL
    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    // GET ALL HOTELS
    @GetMapping("/all")
    public List<Hotel> getAllHotel() {
        return hotelService.getAllHotel();
    }

    // SEARCH BY LOCATION
    @GetMapping("/search")
    public List<Hotel> searchByLocation(@RequestParam String location){
        return hotelService.searchByLocation(location);
    }

    // SEARCH BY HOTEL NAME
    @GetMapping("/hotel-name/{hotelName}")
    public List<Hotel> searchByHotelName(@PathVariable String hotelName){
        return hotelService.searchByHotelName(hotelName);
    }

    // GET HOTEL BY ID
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    // DELETE HOTEL
    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);

        return "Hotel deleted successfully";
    }

    // UPDATE HOTEL
    @PutMapping("/update/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel){
        return hotelService.updateHotel(id, hotel);
    }
    
    
    @GetMapping("/search-all")
    public List<Hotel> searchHotels(@RequestParam String keyword){

        List<Hotel> hotelsByLocation =
        hotelService.searchByLocation(keyword);

        List<Hotel> hotelsByName =
        hotelService.searchByHotelName(keyword);

        hotelsByLocation.addAll(hotelsByName);

        return hotelsByLocation;
    }
    
    // FOR POSTMAN HOTEL INSERTION
    @PostMapping("/addAll")
    public List<Hotel> addAllHotel(@RequestBody List<Hotel> hotel){
    	return hotelService.addAllHotel(hotel);
    }
}
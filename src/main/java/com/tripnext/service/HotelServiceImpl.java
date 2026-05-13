package com.tripnext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnext.entity.Hotel;
import com.tripnext.repository.BookingRepository;
import com.tripnext.repository.HotelRepository;

import jakarta.transaction.Transactional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel(){
        return hotelRepo.findAll();
    }

    @Override
    public List<Hotel> searchByLocation(String location){
        return hotelRepo.findByLocationContainingIgnoreCase(location);
    }

    @Override
    public List<Hotel> searchByHotelName(String hotelName){
        return hotelRepo.findByHotelNameContaining(hotelName);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepo.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteHotel(Long id) {
        bookingRepository.deleteByHotel_Id(id);
        hotelRepo.deleteById(id);
    }
    
    @Override
    public Hotel updateHotel(Long id, Hotel updatedHotel) {

        Hotel existingHotel =
        hotelRepo.findById(id).orElse(null);

        if(existingHotel != null){

            existingHotel.setHotelName(
                    updatedHotel.getHotelName());

            existingHotel.setLocation(
                    updatedHotel.getLocation());

            existingHotel.setImageUrl(
                    updatedHotel.getImageUrl());

            existingHotel.setPrice(
                    updatedHotel.getPrice());

            existingHotel.setRating(
                    updatedHotel.getRating());

            existingHotel.setDescription(
                    updatedHotel.getDescription());

            return hotelRepo.save(existingHotel);
        }

        return null;
    }
    
    @Override
    public List<Hotel> addAllHotel(List<Hotel> hotel){
    	return hotelRepo.saveAll(hotel);
    }
    

}
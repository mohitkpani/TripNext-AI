package com.tripnext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnext.entity.Place;
import com.tripnext.repository.PlaceRepository;

@Service
public class PlaceServiceImpl implements PlaceService{

    @Autowired
    private PlaceRepository placeRepository;

    // ADD PLACE
    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    // GET ALL PLACES
    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    // GET PLACE BY ID
    @Override
    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    // DELETE PLACE
    @Override
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

    // UPDATE PLACE
    @Override
    public Place updatePlace(Long id,Place updatedPlace) {

        Place existingPlace = placeRepository.findById(id).orElse(null);

        if(existingPlace != null){

            existingPlace.setPlaceName(
                    updatedPlace.getPlaceName());

            existingPlace.setLocation(
                    updatedPlace.getLocation());

            existingPlace.setImageUrl(
                    updatedPlace.getImageUrl());

            existingPlace.setCategory(
                    updatedPlace.getCategory());

            existingPlace.setDescription(
                    updatedPlace.getDescription());

            return placeRepository
                    .save(existingPlace);
        }

        return null;
    }

    // SEARCH BY PLACE NAME
    @Override
    public List<Place>
    searchByPlaceName(String placeName) {
        return placeRepository.findByPlaceNameContainingIgnoreCase( placeName);
    }

    // SEARCH BY LOCATION
    @Override
    public List<Place> searchByLocation(String location) {
        return placeRepository.findByLocationContainingIgnoreCase(location);
    }
    
    //ADD MULTIPLE PLACES FOR POSTMAN 
    @Override
    public List<Place> addAllPlaces(List<Place> places){
    	    return placeRepository.saveAll(places);
    	
    }

}
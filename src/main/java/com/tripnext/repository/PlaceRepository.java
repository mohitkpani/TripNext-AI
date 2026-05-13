package com.tripnext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripnext.entity.Place;

public interface PlaceRepository
extends JpaRepository<Place, Long>{

    // SEARCH BY PLACE NAME
    List<Place> findByPlaceNameContainingIgnoreCase(String placeName);

    // SEARCH BY LOCATION
    List<Place>
    findByLocationContainingIgnoreCase(String location);
    
    
}
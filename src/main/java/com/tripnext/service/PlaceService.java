package com.tripnext.service;

import java.util.List;

import com.tripnext.entity.Place;

public interface PlaceService {

    Place addPlace(Place place);

    List<Place> addAllPlaces(List<Place> places);

    List<Place> getAllPlaces();

    Place getPlaceById(Long id);

    void deletePlace(Long id);

    Place updatePlace(Long id, Place place);

    List<Place> searchByPlaceName(String placeName);

    List<Place> searchByLocation(String location);
}
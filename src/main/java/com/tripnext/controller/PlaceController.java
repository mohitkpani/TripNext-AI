package com.tripnext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tripnext.entity.Place;
import com.tripnext.service.PlaceService;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    // ADD PLACE
    @PostMapping("/add")
    public Place addPlace(@RequestBody Place place){
        return placeService.addPlace(place);
    }
    
    // ADD MULTIPLE PLACE
    @PostMapping("/addAll")
    public List<Place> addAllPlaces(@RequestBody List<Place> places) {
        return placeService.addAllPlaces(places);
    }

    // GET ALL PLACES
    @GetMapping("/all")
    public List<Place> getAllPlaces(){ 
    	return placeService.getAllPlaces();
    }

    // GET PLACE BY ID
    @GetMapping("/{id}")
    public Place getPlaceById( @PathVariable Long id){
        return placeService.getPlaceById(id);
    }

    // DELETE PLACE
    @DeleteMapping("/delete/{id}")
    public String deletePlace( @PathVariable Long id){
    	placeService.deletePlace(id);
        return "Place deleted successfully";
    }

    // UPDATE PLACE
    @PutMapping("/update/{id}")
    public Place updatePlace( @PathVariable Long id, @RequestBody Place place){
        return placeService.updatePlace(id, place);
    }

    // SEARCH BY PLACE NAME
    @GetMapping("/search/{placeName}")
    public List<Place>
    searchByPlaceName( @PathVariable String placeName){
    	return placeService.searchByPlaceName(placeName);
    }

    // SEARCH BY LOCATION
    @GetMapping("/location/{location}")
    public List<Place>
    searchByLocation(@PathVariable String location){
        return placeService.searchByLocation(location);
    }
    

}
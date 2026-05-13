package com.tripnext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExploreController {

    // EXPLORE PLACES PAGE
    @GetMapping("/explore-places")
    public String explorePlaces(){
        return "explore-places";
    }

    // PLACE DETAILS PAGE
    @GetMapping("/place-details")
    public String placeDetailsPage(){
        return "place-details";
    }
}
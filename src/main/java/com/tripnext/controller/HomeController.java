package com.tripnext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/hotels")
	public String hotelPages() {
		return "hotels";
	}
	
	@GetMapping("/hotel-details")
	public String hotelDetailsPage() {
		return "hotel-details";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage() {
		return "dashboard";
	}
	
	@GetMapping("/admin")
	public String adminDashboardPage() {
		return "admin-dashboard";
	}
	
	@GetMapping("/add-hotel")
	public String addHotelPage() {
		return "add-hotel";
	}
	
	@GetMapping("/manage-hotels")
	public String manageHotelsPage() {
		return "manage-hotels";
	}
	
	@GetMapping("/edit-hotel")
	public String editHotelPage() {
		return "edit-hotel";
	}
	
	@GetMapping("/admin-bookings")
	public String adminBookingsPage(){
	    return "admin-bookings";
	}
	
	@GetMapping("/users")
	public String usersPage(){
	    return "users";
	}
	
	@GetMapping("/search-hotels")
	public String searchHotelsPage(){
	    return "search-hotels";
	}
	
	@GetMapping("/analytics")
	public String analyticsPage(){
	    return "analytics";
	}
	
	@GetMapping("/settings")
	public String settingsPage(){
	    return "settings";
	}
	
	@GetMapping("/ai-chat")
	public String aiChatPage(){
	    return "ai-chat";
	}
	
	@GetMapping("/add-place")
	public String addPlacePage(){
	    return "add-place";
	}

	@GetMapping("/manage-places")
	public String managePlacesPage(){
	    return "manage-places";
	}

	@GetMapping("/update-place")
	public String updatePlacePage(){
	    return "update-place";
	}
	
	@GetMapping("/my-bookings")
	public String myBookingPage() {
		return "my-bookings";
	}
	
	@GetMapping("/admin-dashboard")
	public String adminDashboard(){
	    return "admin-dashboard";
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

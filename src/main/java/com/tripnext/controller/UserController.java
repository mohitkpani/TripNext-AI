package com.tripnext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripnext.dto.LoginRequest;
import com.tripnext.entity.Role;
import com.tripnext.entity.User;
import com.tripnext.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	// REGISTER API
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	// REGISTER FOR ADMIN API
	@PostMapping("/create-admin")
	public User createAdmin(@RequestBody User user){
	    user.setRole(Role.ADMIN);
	    return userService.registerUser(user);
	}
	
	// LOGIN API
	@PostMapping("/login")
	public User loginUser(@RequestBody LoginRequest loginrequest) {
		return userService.loginUser(loginrequest.getEmail(), loginrequest.getPassword());
	}
	
	// GET ALL USERS
	@GetMapping("/all")
	public List<User> getAllUsers(){
	    return userService.getAllUsers();
	}
}

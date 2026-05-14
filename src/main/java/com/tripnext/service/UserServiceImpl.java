package com.tripnext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnext.entity.Role;
import com.tripnext.entity.User;
import com.tripnext.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailService emailService;
	
	
	@Override
	public User registerUser(User user) {

    if(user.getRole() == null) {
        user.setRole(Role.USER);
    }

    // Save user first
    User savedUser = userRepo.save(user);

    // Try sending email
    try {

        emailService.sendEmail(

                user.getEmail(),

                "Welcome to TripNext AI",

                "Hello " + user.getName() +

                ",\n\nWelcome to TripNext AI!\n\n" +

                "Your account has been created successfully.\n\n" +

                "Enjoy booking hotels with us.\n\n" +

                "Team TripNext AI"
        );

    } catch (Exception e) {

        System.out.println("Email sending failed");
        e.printStackTrace();
    }

    return savedUser;
}
	
	@Override
	public User loginUser(String email, String password) {
		User user = userRepo.findByEmail(email).orElse(null);
		
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}
	
	@Override
	public List<User> getAllUsers() {
	    return userRepo.findAll();
	}
	
	
}

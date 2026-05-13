package com.tripnext.service;

import java.util.List;

import com.tripnext.entity.User;

public interface UserService {
	
	User registerUser(User user);
	User loginUser(String email, String password);
	List<User> getAllUsers();
}

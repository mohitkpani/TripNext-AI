package com.tripnext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        try {

            User savedUser = userService.registerUser(user);

            return ResponseEntity.ok(savedUser);

        }

        catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }

        catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Registration failed");
        }
    }

    // REGISTER FOR ADMIN API
    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdmin(@RequestBody User user){

        try {

            user.setRole(Role.ADMIN);

            User savedAdmin = userService.registerUser(user);

            return ResponseEntity.ok(savedAdmin);

        }

        catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }

        catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Admin registration failed");
        }
    }

    // LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginrequest) {

        User user = userService.loginUser(
                loginrequest.getEmail(),
                loginrequest.getPassword()
        );

        if(user != null) {

            return ResponseEntity.ok(user);

        } else {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Email or Password");
        }
    }

    // GET ALL USERS
    @GetMapping("/all")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }
}
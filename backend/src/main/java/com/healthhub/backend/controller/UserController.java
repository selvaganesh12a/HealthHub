package com.healthhub.backend.controller;

import com.healthhub.backend.entity.User;
import com.healthhub.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173") // Allow React app
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        User user = userService.loginUser(username, password);
        System.out.println("DEBUG: Login User: " + user);
        return ResponseEntity.ok(user);
    }
}

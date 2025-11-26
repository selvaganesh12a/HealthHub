package com.healthhub.backend.service;

import com.healthhub.backend.entity.User;
import com.healthhub.backend.exception.InvalidCredentialsException;
import com.healthhub.backend.exception.UserAlreadyExistsException;
import com.healthhub.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists: " + user.getUsername());
        }
        // In a real app, we would hash the password here.
        // Requirement says store directly, so saving as is.
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new InvalidCredentialsException("Invalid username or password");
    }
}

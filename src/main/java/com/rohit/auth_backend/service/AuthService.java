package com.rohit.auth_backend.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rohit.auth_backend.repository.UserRepository;
import com.rohit.auth_backend.model.User;

@Service
@RequiredArgsConstructor
public class AuthService {
    
	@Autowired
    private  UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public boolean login(User user) {
        return userRepository.findByEmail(user.getEmail())
                .map(u -> u.getPassword().equals(user.getPassword()))
                .orElse(false);
    }
}
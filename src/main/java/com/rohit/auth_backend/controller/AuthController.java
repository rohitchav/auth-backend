package com.rohit.auth_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.rohit.auth_backend.service.AuthService;
import com.rohit.auth_backend.model.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
    private  AuthService authService ;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
    	System.out.println("User: "+user.toString());
        authService.register(user);
        return ResponseEntity.ok(
                Map.of(
                    "status", "success",
                    "message", "User Registered Successfully"
                )
            );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
    	System.out.println("User: "+user.toString());
        boolean valid = authService.login(user);

        if(valid) {
        	return ResponseEntity.ok(
                    Map.of(
                        "status", "success",
                        "message", "Login Successfully"
                    )
                );
        }
        return ResponseEntity.status(401).body("Invalid Credentials");
    }
}
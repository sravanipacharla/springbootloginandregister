package com.crud.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.entity.User;
import com.crud.example.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		User registeredUser = userservice.registerUser(user);
		if (registeredUser != null) {
			return ResponseEntity.ok("User registered successfully.");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed.");
	}

//	@PostMapping("/login")
//	        public ResponseEntity<String> loginUser (@RequestBody String username,@RequestBody String password) {
//	            boolean authenticated = userservice.loginUser(username, password);
//	            if (authenticated) {
//	                return ResponseEntity.ok("Login successful.");
//	            }
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
//	        }
//	    }
//
//}
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestParam("username") String username,
			@RequestParam("password") String password,@RequestParam("email")String email) {
		boolean authenticated = userservice.loginUser(username, password,email);
		if (authenticated) {
			return ResponseEntity.ok("Login successful.");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
	}
}

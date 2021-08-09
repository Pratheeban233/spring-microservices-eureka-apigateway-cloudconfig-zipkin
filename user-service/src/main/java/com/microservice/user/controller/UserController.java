package com.microservice.user.controller;

import com.microservice.user.entity.User;
import com.microservice.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/adduser")
	public ResponseEntity<User> saveUser (@RequestBody User user) {
		log.info("Inside saveUser of UserController.");
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable("id") Long userId){
		log.info("Inside getUserById of UserController.");
		return ResponseEntity.ok(userService.getUserWithDepartmentById(userId));
	}
}

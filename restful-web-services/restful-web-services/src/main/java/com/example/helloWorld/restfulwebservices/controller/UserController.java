package com.example.helloWorld.restfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloWorld.restfulwebservices.dto.User;
import com.example.helloWorld.restfulwebservices.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/submitUser")
	public Long createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}

package com.example.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.model.User;
import com.example.interview.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	@GetMapping("/getUserByNameParam")
	public List<User> getUserByNameParam(@RequestParam String name) {
		return userService.getUserByName(name);
	}

}

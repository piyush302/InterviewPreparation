package com.example.interview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.interview.controller.repo.UserRepository;
import com.example.interview.model.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User u) {
		return userRepository.save(u);
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public List<User> getUserByName(String name) {
		return userRepository.findByName(name);
	}
}

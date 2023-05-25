package com.example.interview.controller.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.interview.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByName(String name);

}

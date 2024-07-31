package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.signupDBRepo;

import com.entity.signUp;

@RestController
@RequestMapping("/signup")
@CrossOrigin("http://localhost:3000")
public class signupController {
	
	@Autowired
	signupDBRepo repo;
	

	@PostMapping("/userSignUp")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Map<String, String>> addDetails (@RequestBody signUp sdb){
		Map<String, String> response = new HashMap<>();
		response.put("message","Sign up details added successfully");
		 repo.save(sdb);
		return ResponseEntity.ok(response);
	}
}

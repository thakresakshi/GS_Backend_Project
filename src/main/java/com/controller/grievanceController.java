package com.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.grievanceDBRepo;
import com.entity.grievanceDB;
import com.entity.hodDB;

@RestController
@RequestMapping("/grievance")
@CrossOrigin("http://localhost:3000")
public class grievanceController {
	
	@Autowired
	grievanceDBRepo repo;
	
	@PostMapping("/submitGrievance")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Map<String, String>> submitGrievance (@RequestBody grievanceDB gdb){
		Map<String, String> response = new HashMap<>();
		response.put("message","Grievance added successfully");
		 repo.save(gdb);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/getAllGrivance")
	@CrossOrigin("http://localhost:3000")
    public ResponseEntity<List<grievanceDB>> getAllGrievances() {
        List<grievanceDB> grievances = repo.findAll();
        return new ResponseEntity<>(grievances, HttpStatus.OK);
    }
}

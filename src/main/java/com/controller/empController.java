package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.empDBRepo;
import com.entity.empDB;
import com.service.empService;

@RestController
@RequestMapping("/emp")
@CrossOrigin("http://localhost:3000")
public class empController {
	
	@Autowired
	empDBRepo repo;
	private empService service;

	
	@PostMapping("/empData")
	public ResponseEntity<Map<String, String>>prmData (@RequestBody empDB edb){
		Map<String, String> response = new HashMap<>();
		response.put("message","EMP Data added successfully");
		 repo.save(edb);
		return ResponseEntity.ok(response);
	
	}
		
	 @GetMapping("/getAll")
	    public ResponseEntity<List<empDB>> getAllGrievances() {
	        List<empDB> grievances = service.getAllGrievances();
	        return new ResponseEntity<>(grievances, HttpStatus.OK);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<empDB> getGrievanceById(@PathVariable String grievanceId) {
	    	empDB grievance = service.getGrievanceById(grievanceId);
	        if (grievance != null) {
	            return new ResponseEntity<>(grievance, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	    //updating the grievance status
	 @PutMapping("/{id}/status")
	    public ResponseEntity<empDB> updateGrievanceStatus(@PathVariable String grievanceId, @RequestParam String status) {
	    	empDB updatedGrievance = service.updateGrievanceStatus(grievanceId, status);
	        if (updatedGrievance != null) {
	            return new ResponseEntity<>(updatedGrievance, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}

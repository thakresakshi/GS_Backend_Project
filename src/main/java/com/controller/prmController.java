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

import com.dao.prmDBRepo;
import com.entity.grievanceDB;
import com.entity.prmDB;
import com.service.prmService;

@RestController
@RequestMapping("/prm/grievances")
@CrossOrigin("http://localhost:3000")
public class prmController {
	
	@Autowired
	prmDBRepo repo;
	
	@PostMapping("/prmData")
	public ResponseEntity<Map<String, String>>prmData (@RequestBody prmDB pdb){
		Map<String, String> response = new HashMap<>();
		response.put("message","PRM Data added successfully");
		 repo.save(pdb);
		return ResponseEntity.ok(response);
	}
	
	@Autowired
	private prmService service;
		
	 @GetMapping("/getAll")
	 @CrossOrigin("http://localhost:3000")
	    public ResponseEntity<List<grievanceDB>> getAllGrievances() {
	        List<grievanceDB> grievances = service.getAllGrievances();
	        return new ResponseEntity<>(grievances, HttpStatus.OK);
	    }
	 
	 @GetMapping("/{id}")
	 @CrossOrigin("http://localhost:3000")
	    public ResponseEntity<grievanceDB> getGrievanceById(@PathVariable String grievanceId) {
	    	grievanceDB grievance = service.getGrievanceById(grievanceId);
	        if (grievance != null) {
	            return new ResponseEntity<>(grievance, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	    //updating the grievance status
	 @PutMapping("/{id}/status")
	    public ResponseEntity<prmDB> updateGrievanceStatus(@PathVariable String grievanceId, @RequestParam String status) {
	        prmDB updatedGrievance = service.updateGrievanceStatus(grievanceId, status);
	        if (updatedGrievance != null) {
	            return new ResponseEntity<>(updatedGrievance, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
}

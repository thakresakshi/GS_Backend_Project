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

import com.dao.hodDBRepo;
import com.entity.hodDB;
import com.entity.prmDB;
import com.service.hodService;
import com.service.prmService;

@RestController
@RequestMapping("/hod")
@CrossOrigin("http://localhost:3000")
public class hodController {
	
	@Autowired
	hodDBRepo repo;
	
	@PostMapping("/hodData")
	public ResponseEntity<Map<String,String>>hodData (@RequestBody hodDB hdb){
		Map<String, String> response = new HashMap<>();
		response.put("message","HOD Data added successfully");
		 repo.save(hdb);
		return ResponseEntity.ok(response);
	}
	
	
	@Autowired
	private hodService service;
		
	 @GetMapping("/getAll")
	    public ResponseEntity<List<hodDB>> getAllGrievances() {
	        List<hodDB> grievances = service.getAllGrievances();
	        return new ResponseEntity<>(grievances, HttpStatus.OK);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<hodDB> getGrievanceById(@PathVariable String grievanceId) {
	    	hodDB grievance = service.getGrievanceById(grievanceId);
	        if (grievance != null) {
	            return new ResponseEntity<>(grievance, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	    //updating the grievance status
	 @PutMapping("/{id}/status")
	    public ResponseEntity<hodDB> updateGrievanceStatus(@PathVariable String grievanceId, @RequestParam String status) {
	    	hodDB updatedGrievance = service.updateGrievanceStatus(grievanceId, status);
	        if (updatedGrievance != null) {
	            return new ResponseEntity<>(updatedGrievance, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	

}

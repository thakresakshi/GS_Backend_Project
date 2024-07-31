package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.hodDBRepo;
import com.entity.hodDB;
import com.entity.prmDB;

@Service
public class hodService {
	
	@Autowired
	private hodDBRepo repo;
	
	 public List<hodDB> getAllGrievances() {
	        return repo.findAll();
	    }

	    public hodDB getGrievanceById(String grievanceId) {
	        return repo.findById(grievanceId).orElse(null);
	    }

	    public hodDB updateGrievanceStatus(String grievanceId, String status) {
	    	hodDB grievance = repo.findById(grievanceId).orElse(null);
	        if (grievance != null) {
	            grievance.setStatus(status);
	            return repo.save(grievance);
	        }
	        return null;
	    }

}

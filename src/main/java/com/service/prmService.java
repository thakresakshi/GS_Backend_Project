package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.grievanceDBRepo;
import com.dao.prmDBRepo;
import com.entity.grievanceDB;
import com.entity.prmDB;

@Service
public class prmService {
	 	@Autowired
	    private grievanceDBRepo repo;

	 	public List<grievanceDB> getAllGrievances() {
	        return repo.findAll();
	    }

	    public grievanceDB getGrievanceById(String grievanceId) {
	        return repo.findById(grievanceId).orElse(null);
	    }

	    @Autowired
	    private prmDBRepo prmrepo;
	    public prmDB updateGrievanceStatus(String grievanceId, String status) {
	    	prmDB grievance = prmrepo.findById(grievanceId).orElse(null);
	        if (grievance != null) {
	            grievance.setStatus(status);
	            return prmrepo.save(grievance);
	        }
	        return null;
	    }
}

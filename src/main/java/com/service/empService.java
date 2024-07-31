package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.empDBRepo;
import com.entity.empDB;

@Service
public class empService {
	@Autowired
    private empDBRepo repo;

    public List<empDB> getAllGrievances() {
        return repo.findAll();
    }

    public empDB getGrievanceById(String grievanceId) {
        return repo.findById(grievanceId).orElse(null);
    }

    public empDB updateGrievanceStatus(String grievanceId, String status) {
    	empDB grievance = repo.findById(grievanceId).orElse(null);
        if (grievance != null) {
            grievance.setStatus(status);
            return repo.save(grievance);
        }
        return null;
    }
}

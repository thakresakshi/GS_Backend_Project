package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.grievanceDB;

public interface grievanceDBRepo extends JpaRepository<grievanceDB,String> {
	
}

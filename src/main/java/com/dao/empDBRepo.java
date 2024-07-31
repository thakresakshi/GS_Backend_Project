package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.empDB;

public interface empDBRepo extends JpaRepository<empDB, String> {

}

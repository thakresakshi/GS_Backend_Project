package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.prmDB;

public interface prmDBRepo extends JpaRepository<prmDB, String> {

}

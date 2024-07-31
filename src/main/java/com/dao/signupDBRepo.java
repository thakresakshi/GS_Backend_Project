package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.signUp;
import java.util.List;


public interface signupDBRepo extends JpaRepository<signUp, String> {
	List<signUp> findByUsername(String username);
}

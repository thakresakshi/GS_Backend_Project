package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.signUp;
import com.service.loginServiceImpl;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class loginController {

	String result; 
    @Autowired
    loginServiceImpl loginservice;
    
    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestParam (name = "username")String  username,@RequestParam (name = "password")String  password ) {
             
    	
        try {
             result = loginservice.loginValidation(username, password);
            System.out.println(result);
            return ResponseEntity.ok(result); // Return HTTP 200 OK with result
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
            // Return HTTP 500 Internal Server Error with error message
        }
    }
}

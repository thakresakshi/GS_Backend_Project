package com.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.signupDBRepo;
import com.entity.signUp;



@Service
public class loginServiceImpl {
	
	Connection connection;
	String flag;
	@Autowired
	signupDBRepo logindb;
	public loginServiceImpl() throws SQLException {
		connection = com.DBUtil.DBUtil.getConnection();
	}
	public  String loginValidation(String username, String password) {
		try {
			
			List<signUp> l1 = logindb .findByUsername(username);
			
			if( l1 != null ) {
				for (signUp signUp : l1) {
					if (signUp.getPassword().equals(password) ) {
						return flag=signUp.getRole();
						}
					}
				}
			
			}catch(Exception e) {
				e.printStackTrace();
		}
		return flag =null ;
	}
}

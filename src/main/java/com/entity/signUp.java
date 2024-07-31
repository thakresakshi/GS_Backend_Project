package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="signupDB")
public class signUp {
	@Id
	private String empId;
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String username;
	@Column(length=50)
	private String password;
	@Column(length=50)
	private String role;
	@Column(length=50)
	private String email;
	@Column(length=20)
	private String mobileNo;
	@Override
	public String toString() {
		return "signUp [empId=" + empId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	


}

package com.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Grievances")
public class grievanceDB {
	@Id @Column(length=6)
	private String grievanceId;
	@Column(length=30)
	private String date;
	@Column(length=40)
	private String fullName;
	@Column (length=40)
	private String email;
	@Column(length=10)
	private String mobile;
	@Column(length=20)
	private String tehsilName;
	@Column(length=20)
	private String villageName;
	@Column(length=100)
	private String address;
	@Column(length=12)
	private String aadharNo;
	@Column
	private String grievance;

	
}

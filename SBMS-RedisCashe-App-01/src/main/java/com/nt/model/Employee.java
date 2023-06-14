package com.nt.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE-INFO")
public class Employee implements Serializable{
		@Id
		@Column(name = "EMP_ID")
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Integer eid;
		
		@Column(name = "EMP_FNAME")
		private String fname;
		
		@Column(name = "EMP_LNAME")
		private String lname;
		
		@Column(name = "EMP_EMAIL")
		private String email;
		
		@Column(name = "EMP_AGE")
		private Integer age;
		
		@Column(name = "EMP_PHONE")
		private Long phone;
		
		@Column(name = "EMP_ADDRESS")
		private String address;
}

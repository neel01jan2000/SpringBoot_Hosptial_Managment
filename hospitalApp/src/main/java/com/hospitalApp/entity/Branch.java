package com.hospitalApp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Branch {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int b_id;
	private String b_name;
	private long b_pincode;
	
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<Patient> patients;
}

package com.hospitalApp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int h_id;
	private String h_name;
	private long h_phone;
	private String h_email;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Branch> branch;
}

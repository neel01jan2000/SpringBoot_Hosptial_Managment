package com.hospitalApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Prescription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pre_id;
	private String name;
	private String description;
	
}

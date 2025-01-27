package com.hospitalApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int p_id;
	private String name;
	private int age;
	private String treatment;
	
	@OneToOne(mappedBy ="patient")
	private Appointment appointment;
}

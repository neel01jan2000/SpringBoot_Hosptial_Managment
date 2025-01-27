package com.hospitalApp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ap_id;
	private String doctorName;
	private double fees;
	
	@JoinColumn
	@OneToOne
	private Patient patient;
	
	@OneToMany
	private List<Prescription> prescription;
}

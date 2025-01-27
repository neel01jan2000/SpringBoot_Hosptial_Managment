package com.hospitalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalApp.entity.Patient;
import com.hospitalApp.service.PatientService;
import com.hospitalApp.util.ResponseStructure;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientservice;

//	save Patient with respect to branch
	@PostMapping("/savePatient/{b_id}")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@PathVariable int b_id, @RequestBody Patient pat) {
		return patientservice.savePatient(b_id,pat);
	}
	
//	find Patient by id
}

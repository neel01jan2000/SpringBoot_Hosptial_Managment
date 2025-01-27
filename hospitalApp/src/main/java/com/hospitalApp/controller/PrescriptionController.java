package com.hospitalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalApp.entity.Prescription;
import com.hospitalApp.service.PrescriptionService;
import com.hospitalApp.util.ResponseStructure;

@RestController
public class PrescriptionController {

	@Autowired
	private PrescriptionService Prescription;
	
//	save prescription with respect to appointment
	@PostMapping("/savePrescription/{a_id}")
	public ResponseEntity<ResponseStructure<Prescription>> savePrscription(@PathVariable int a_id, @RequestBody Prescription pres){
		return Prescription.savePrescription(a_id,pres);
	}
	
//	find prescription by id
}

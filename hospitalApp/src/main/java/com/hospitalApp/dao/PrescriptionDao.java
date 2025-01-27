package com.hospitalApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalApp.entity.Prescription;
import com.hospitalApp.repository.PrescriptionRepo;

@Repository
public class PrescriptionDao {

	@Autowired
	private PrescriptionRepo prescriptionrepo;
	
//	save Prescription
	public Prescription savePrescription(Prescription p) {
		return prescriptionrepo.save(p);
	}
}

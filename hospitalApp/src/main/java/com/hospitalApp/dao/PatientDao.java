package com.hospitalApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalApp.entity.Patient;
import com.hospitalApp.repository.PatientRepo;

@Repository
public class PatientDao {

	@Autowired
	private PatientRepo patientrepo;
	
//	save patient
	public Patient savePatient(Patient p) {
		return patientrepo.save(p);
	}

//	find patient by id
	public Patient findPatienById(int p_id) {
		Optional<Patient> op =  patientrepo.findById(p_id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
}

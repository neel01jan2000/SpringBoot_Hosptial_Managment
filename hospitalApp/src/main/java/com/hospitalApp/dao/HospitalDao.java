package com.hospitalApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalApp.entity.Hospital;
import com.hospitalApp.repository.HospitalRepo;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepo hospitalRepo;
	
//	save the hospital
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}
	
//	Find By id
	public Hospital findHospitalById(int id) {
		Optional<Hospital> op =  hospitalRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
	
//	find hospital by name
	public Hospital findHospitalByName(String h_name) {
		Hospital h =  hospitalRepo.findHospitalByName(h_name);
		if(h!=null) {
			return h;
		}
		else {
			return null;
		}
	}
	
//	find hosptial by branch
	public Hospital findByBranch(String b_name) {
		Hospital h =  hospitalRepo.findHospitalByName(b_name);
		if(h!=null) {
			return h;
		}
		else {
			return null;
		}
	}
	
	
	
	
	
}

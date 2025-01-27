package com.hospitalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalApp.entity.Hospital;
import com.hospitalApp.service.HospitalService;
import com.hospitalApp.util.ResponseStructure;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalservice;
	
//	save hospital
	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital h){
		return hospitalservice.saveHospital(h);
	}
	
//	find hospital by id
	@GetMapping("/findHopital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>>  findHospitalById(@PathVariable int id){
		return hospitalservice.findHospitalByid(id);
	}
	
//	findhospital by name
	@GetMapping("/findHospitalName/{h_name")
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByName(@PathVariable String h_name){
		return hospitalservice.findHospitalByName(h_name);
	}
	
//	find hospital by branch name
	@GetMapping("/findHospialByBranch/{b_name}")
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByBranchName(@PathVariable String b_name){
		return hospitalservice.findHospitalByBranchName(b_name);
	}
}

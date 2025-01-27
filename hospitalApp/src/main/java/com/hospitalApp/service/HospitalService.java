package com.hospitalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospitalApp.dao.HospitalDao;
import com.hospitalApp.entity.Hospital;
import com.hospitalApp.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitaldao;
	
//	save Hospital
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital h){
		ResponseStructure<Hospital> rs= new ResponseStructure<Hospital>();
		
		Hospital hos = hospitaldao.saveHospital(h);
		rs.setData(hos);
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("Succusfully Data stored");
		return new ResponseEntity<ResponseStructure<Hospital>>(rs,HttpStatus.CREATED);
	}

//	find hospital by id
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByid(int id) {
		ResponseStructure<Hospital> rs= new ResponseStructure<Hospital>();
		Hospital hs = hospitaldao.findHospitalById(id);
		
		rs.setData(hs);
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setMessage("Succusfully Data stored");
		return new ResponseEntity<ResponseStructure<Hospital>>(rs,HttpStatus.ACCEPTED);
	}
	
//	find hospital by name
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByName(String h_name){
		ResponseStructure<Hospital> rs= new ResponseStructure<Hospital>();
		
		Hospital hos = hospitaldao.findHospitalByName(h_name);
		rs.setData(hos);
		rs.setMessage("Success");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(rs,HttpStatus.OK);
	}
	
//	find Hospital by branch name
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByBranchName(String b_name){
		ResponseStructure<Hospital> rs = new ResponseStructure<Hospital>();
		Hospital hs = hospitaldao.findByBranch(b_name);
		
		rs.setData(hs);
		rs.setMessage("Success");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(HttpStatus.OK);
	}
	
	
	
}

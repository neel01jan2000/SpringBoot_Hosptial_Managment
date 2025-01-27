package com.hospitalApp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospitalApp.dao.BranchDao;
import com.hospitalApp.dao.HospitalDao;
import com.hospitalApp.entity.Branch;
import com.hospitalApp.entity.Hospital;
import com.hospitalApp.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchdao;
	@Autowired
	private HospitalDao hospitaldao;
	
//	save branch with respect to hospital
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int h_id, Branch b) {
	    ResponseStructure<Branch> rs = new ResponseStructure<>();

	    // Fetch the hospital from the database
	    Hospital h = hospitaldao.findHospitalById(h_id);
	    if (h != null) { // Ensure hospital exists
	        // Initialize branch list if it is null
	        if (h.getBranch() == null) {
	            h.setBranch(new ArrayList<>());
	        }

	        // Add the branch to the hospital's branch list
	        h.getBranch().add(b);

	        // Save the hospital, cascading will handle saving the branch
	        hospitaldao.saveHospital(h);

	        // Prepare response
	        rs.setData(b);
	        rs.setMessage("Branch data saved successfully");
	        rs.setStatusCode(HttpStatus.CREATED.value());
	        return new ResponseEntity<>(rs, HttpStatus.CREATED);
	    } else {
	        rs.setMessage("Hospital not found");
	        rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
	        return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.BAD_REQUEST);
	    }
	}

	
	

//	find Branch by id
	public ResponseEntity<ResponseStructure<Branch>> findBranch(int b_id) {
		ResponseStructure<Branch> rs= new ResponseStructure<Branch>();
		Branch b = branchdao.findBranchById(b_id);
		if(b!=null) {
			rs.setData(b);
			rs.setMessage("Succes");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(rs,HttpStatus.OK);
		}
		else {
			rs.setMessage("Data not avilable");
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Branch>>(rs,HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}

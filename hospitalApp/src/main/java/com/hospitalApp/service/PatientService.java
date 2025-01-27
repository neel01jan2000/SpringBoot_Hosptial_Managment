package com.hospitalApp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospitalApp.dao.BranchDao;
import com.hospitalApp.dao.PatientDao;
import com.hospitalApp.entity.Appointment;
import com.hospitalApp.entity.Branch;
import com.hospitalApp.entity.Patient;
import com.hospitalApp.util.ResponseStructure;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientdao;
	@Autowired
	private BranchDao branchdao;
	
//	save patient with respect to branch
	public ResponseEntity<ResponseStructure<Patient>> savePatient(int b_id,Patient pat){
		ResponseStructure<Patient> rs=new ResponseStructure<Patient>();
		Branch b = branchdao.findBranchById(b_id);
		if(b!=null) {
			ArrayList<Patient> al = new ArrayList<Patient>();
			al.add(pat);
			b.setPatients(al);
			patientdao.savePatient(pat);
			rs.setData(pat);
			rs.setMessage("Patient data saved");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Patient>>(rs,HttpStatus.ACCEPTED);
		}
		else {
			rs.setMessage("Patient not data saved");
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Patient>>(rs,HttpStatus.BAD_REQUEST);
		}
	}
	
//	find patient by id
	public ResponseEntity<ResponseStructure<Patient>> findAppointmentById(int p_id){
		ResponseStructure<Patient> rs= new ResponseStructure<Patient>();
		Patient pt = patientdao.findPatienById(p_id);
		if(pt!=null) {
			rs.setData(pt);
			rs.setMessage("Sucess");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Patient>>(rs,HttpStatus.OK);
		}
		else {
			rs.setMessage("Data not available");
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Patient>>(rs,HttpStatus.NOT_FOUND);
		}
	}
	
}

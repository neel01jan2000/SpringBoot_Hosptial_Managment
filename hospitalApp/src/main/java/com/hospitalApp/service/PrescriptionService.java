package com.hospitalApp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospitalApp.dao.AppointmentDao;
import com.hospitalApp.dao.PrescriptionDao;
import com.hospitalApp.entity.Appointment;
import com.hospitalApp.entity.Prescription;
import com.hospitalApp.util.ResponseStructure;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionDao prescriptiondao;
	
	@Autowired
	private AppointmentDao appointmentdao;
	
//	save Prescription with respect to appointment
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(int a_id,Prescription pes){
		ResponseStructure<Prescription> rs = new ResponseStructure<Prescription>();
		Appointment ap = appointmentdao.findAppointmentById(a_id);
		
		if(ap!=null) {
			ArrayList<Prescription> al = new ArrayList<Prescription>();
			al.add(pes);
			ap.setPrescription(al);
			prescriptiondao.savePrescription(pes);
			rs.setData(pes);
			rs.setMessage("Prescription data saved");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Prescription>>(rs,HttpStatus.ACCEPTED);
		}
		else {
			rs.setMessage("Prescription data not saved");
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Prescription>>(rs,HttpStatus.BAD_REQUEST);
		}
	}
	
	
//	find Prescription by id
	
	
}

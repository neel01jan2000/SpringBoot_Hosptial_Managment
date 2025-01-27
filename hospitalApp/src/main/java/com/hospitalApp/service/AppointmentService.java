package com.hospitalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospitalApp.dao.AppointmentDao;
import com.hospitalApp.dao.PatientDao;
import com.hospitalApp.entity.Appointment;
import com.hospitalApp.entity.Patient;
import com.hospitalApp.util.ResponseStructure;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao appointmentdao;
	
	@Autowired
	private PatientDao patientdao;
	
//	save appointment with respect to patient
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(int p_id,Appointment apt){
		ResponseStructure<Appointment> rs= new ResponseStructure<Appointment>();
		Patient p = patientdao.findPatienById(p_id);
		
		if(p!=null) {
			Appointment ap = appointmentdao.saveAppointment(apt);
			ap.setPatient(p);
			patientdao.savePatient(p);
			
			rs.setData(ap);
			rs.setMessage("Appointment data saved");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs,HttpStatus.ACCEPTED);
		}
		else {
			rs.setMessage("Appointment data not saved");
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs,HttpStatus.BAD_REQUEST);
		}
	}
	
	
//	find appointment by id
	public ResponseEntity<ResponseStructure<Appointment>> findAppointmentById(int a_id){
		ResponseStructure<Appointment> rs= new ResponseStructure<Appointment>();
		Appointment ap = appointmentdao.findAppointmentById(a_id);
		if(ap!=null) {
			rs.setData(ap);
			rs.setMessage("Sucess");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs,HttpStatus.OK);
		}
		else {
			rs.setMessage("Data not available");
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs,HttpStatus.NOT_FOUND);
		}
	}
	
}

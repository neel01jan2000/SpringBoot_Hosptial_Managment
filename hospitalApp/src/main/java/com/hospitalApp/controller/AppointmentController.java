package com.hospitalApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalApp.entity.Appointment;
import com.hospitalApp.service.AppointmentService;
import com.hospitalApp.util.ResponseStructure;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentservice;

//	save appointment with respect to patient
	@PostMapping("/saveAppointment/{p_id}")
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@PathVariable int p_id, @RequestBody Appointment apt){
		return appointmentservice.saveAppointment(p_id,apt);
	}
	
//	find appintment by id
	@GetMapping("/findAppointment/{a_id}")
	public ResponseEntity<ResponseStructure<Appointment>> findAppointment(@PathVariable int a_id){
		return appointmentservice.findAppointmentById(a_id);
	}
}

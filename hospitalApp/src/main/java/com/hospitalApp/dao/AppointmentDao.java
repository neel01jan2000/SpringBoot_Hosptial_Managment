package com.hospitalApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalApp.entity.Appointment;
import com.hospitalApp.repository.AppointmentRepo;

@Repository
public class AppointmentDao {

	@Autowired
	private AppointmentRepo appointmentrepo;
	
//	save appointment
	public Appointment saveAppointment(Appointment apoint) {
		return appointmentrepo.save(apoint);
	}

//	find appointment by id
	public Appointment findAppointmentById(int a_id) {
		Optional<Appointment> op = appointmentrepo.findById(a_id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
}

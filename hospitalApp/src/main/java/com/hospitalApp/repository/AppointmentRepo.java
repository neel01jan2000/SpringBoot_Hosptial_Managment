package com.hospitalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalApp.entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{

}

package com.hospitalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalApp.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

}

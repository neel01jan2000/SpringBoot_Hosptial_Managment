package com.hospitalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalApp.entity.Prescription;

public interface PrescriptionRepo extends JpaRepository<Prescription, Integer>{

}

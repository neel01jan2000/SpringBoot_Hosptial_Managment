package com.hospitalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospitalApp.entity.Branch;
import com.hospitalApp.entity.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

	@Query("select h from Hospital h where h.h_name=?1")
	public Hospital findHospitalByName(String h_name);
	
	
	@Query("select h from Hospital h JOIN h.branch b where b.b_name=?1")
	public Hospital findByBranch(String b_name);
	
}

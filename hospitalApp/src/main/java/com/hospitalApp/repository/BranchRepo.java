package com.hospitalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalApp.entity.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer>{

}

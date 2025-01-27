package com.hospitalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalApp.entity.Branch;
import com.hospitalApp.service.BranchService;
import com.hospitalApp.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchservice;

//	save branch with respect to hospital id
	@PostMapping("/saveBranch/{h_id}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@PathVariable int h_id, @RequestBody Branch b) {
		return branchservice.saveBranch(h_id, b);
	}

//	find branch by id
	@GetMapping("/findBranch/{b_id}")
	public ResponseEntity<ResponseStructure<Branch>> findBranch(@PathVariable int b_id) {
		return branchservice.findBranch(b_id);
	}

}

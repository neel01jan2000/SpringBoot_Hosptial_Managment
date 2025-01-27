package com.hospitalApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalApp.entity.Branch;
import com.hospitalApp.repository.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepo branchrepo;
	
//	save Branch
	public Branch saveBranch(Branch b) {
		return branchrepo.save(b);
	}
	
//	find branch by id
	public Branch findBranchById(int id) {
		Optional<Branch> op = branchrepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}

}

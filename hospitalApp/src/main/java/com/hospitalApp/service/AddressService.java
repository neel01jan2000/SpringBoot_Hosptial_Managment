package com.hospitalApp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospitalApp.dao.AddressDao;
import com.hospitalApp.dao.BranchDao;
import com.hospitalApp.entity.Address;
import com.hospitalApp.entity.Branch;
import com.hospitalApp.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressdao;
	@Autowired
	private BranchDao branchdao;
	
//	save Addess with respect to branch
	public ResponseEntity<ResponseStructure<Address>> saveAddress(int b_id,Address adr){
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		Branch b = branchdao.findBranchById(b_id);
		
		if(b!=null) {
			ArrayList<Address> al = new ArrayList<Address>();
			al.add(adr);
			b.setAddress(adr);
			Address a= addressdao.saveAddress(adr);
			rs.setData(a);
			rs.setMessage("Address data saved");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.ACCEPTED);
		}
		else {
			rs.setMessage("Address data not saved");
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Address>>(rs,HttpStatus.BAD_REQUEST);
		}
	}

//	find Address by id
	
	public ResponseEntity<ResponseStructure<Address>> findAddressById(int a_id){
		ResponseStructure<Address> rs = new ResponseStructure<Address>();
		Address ad = addressdao.findAddressById(a_id);
		if(ad!=null) {
			rs.setData(ad);
			rs.setMessage("Success");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Address>>(HttpStatus.ACCEPTED);
		}
		else {
			rs.setMessage("Data not available");
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Address>>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
}

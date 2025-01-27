package com.hospitalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalApp.entity.Address;
import com.hospitalApp.service.AddressService;
import com.hospitalApp.util.ResponseStructure;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressservice;
	
//	save Address with respect to branch
	@PostMapping("/saveAddress/{b_id}")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@PathVariable int b_id, @RequestBody Address address){
		return addressservice.saveAddress(b_id,address);
	}
	
	
//	find address by id
	@GetMapping("/findAddress/{a_id}")
	public ResponseEntity<ResponseStructure<Address>> findAddress(@PathVariable int a_id){
		return addressservice.findAddressById(a_id);
	}
}

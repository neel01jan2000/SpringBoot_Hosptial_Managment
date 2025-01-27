package com.hospitalApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalApp.entity.Address;
import com.hospitalApp.repository.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo addressrepo;
	
//	save address
	public Address saveAddress(Address adrs) {
		return addressrepo.save(adrs);
	}
	
// find address
	public Address findAddressById(int a_id) {
		Optional<Address> ad = addressrepo.findById(a_id);
		if(ad.isPresent()) {
			return ad.get();
		}
		else {
			return null;
		}
		
	}
}

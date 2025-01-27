package com.hospitalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalApp.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}

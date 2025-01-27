package com.hospitalApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int a_id;
	private String state;
	private String City;
}

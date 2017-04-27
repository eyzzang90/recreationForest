package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private int id;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "ZIP")
	private String zip;
	
	@JoinColumn(name = "PERSON_ID")
	private Person person;
	
}

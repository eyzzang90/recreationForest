package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Facilities {

	@Id
	@Column(name = "FCLT_ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	
}

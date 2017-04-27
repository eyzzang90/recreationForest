package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class UseFacilities {

	@Id
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RCR_FRST_ID")
	private RecreationForest recreationForest;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FCLT_ID")
	private Facilities facilities;
	
	@Column(name = "CHARGE")
	private int charge;
}

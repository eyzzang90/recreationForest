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
public class Charge {

	@Id
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RCR_FRST_ID")
	private RecreationForest recreationForest;		//휴양림
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE")		
	private Fee fee;										//요금
	
	@Column(name = "CHGE")
	private long charge;									//요금비용
	
}

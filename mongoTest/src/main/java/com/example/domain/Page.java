package com.example.domain;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class Page {
	
	@Size(min = 0)
	private int pageNo;
	
	@DecimalMax(value = "50")
	@Digits(integer=2, fraction=0)
	private int pageSize;
	
	@NotEmpty
	private String sortDirection;
	
	private Direction direction;
	
	@NotEmpty
	private String sortProperties;
	
	public Page(int pageNo, int pageSize, String sortDirection, String sortProperties){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.sortDirection = sortDirection;
		this.sortProperties = sortProperties;
	}
	public Page() {

	}
}

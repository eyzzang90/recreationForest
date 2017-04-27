package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Fee {

	@Id
	@Column(name = "CODE")
	private String code;							//코드 (P: person, C: car, R: rent)
	
	@Column(name = "CONTENT")
	private String content;						//내용
}

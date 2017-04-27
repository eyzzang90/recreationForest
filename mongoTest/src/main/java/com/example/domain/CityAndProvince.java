package com.example.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@Entity
@Document
@Data
public class CityAndProvince {

	@Id
	private String code;

	private String name;
	
//	@OneToMany(mappedBy = "cityAndProvince")
//	private List<RecreationForest> RecreationForests;
}

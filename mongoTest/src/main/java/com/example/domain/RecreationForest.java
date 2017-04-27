package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@Entity
@Document(collection="RecreationForest")
//@Document
@Data
public class RecreationForest {

	@Id
	private String id;
	
	
	private String name;
	
	private String type;
	
	private String area;
	
	private String cpcty;		//capacity
	
	private String stayingYn;
	
	private String addr;		//address
	
	private String baseDt;
	
	private String tel1;
	
	private String tel2;
	
	private String tel3;
	
	private String siteUrl;
	
	private String la;	//latitude
	
	private String lo;		//longitude
	
	private String orgnName;		//organName
	
	private String cpCode;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "code")
//	private CityAndProvince cityAndProvince;
	
//	@OneToMany(mappedBy = "recreationForest")
//	private List<UseFacilities> useFacilities = new ArrayList<UseFacilities>();
//	
//	@OneToMany(mappedBy = "recreationForest")
//	private List<Charge> charge = new ArrayList<Charge>();
//	
	
	
}

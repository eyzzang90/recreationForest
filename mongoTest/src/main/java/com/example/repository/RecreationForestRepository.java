package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.RecreationForest;

//@Repository
//public interface RecreationForestRepository extends CrudRepository<RecreationForest, ObjectId>{
public interface RecreationForestRepository extends MongoRepository<RecreationForest, Long>{

	Page<RecreationForest> findByCpCode(String code, Pageable pageable);
	Page<RecreationForest> findByName(String name, Pageable pageable);
	Page<RecreationForest> findByType(String type, Pageable pageable);
	Page<RecreationForest> findAll(Pageable pageable);
	
	//deleteByLastName
	//removeByLastName
	//countByLastName
	//findByLastName
	
}

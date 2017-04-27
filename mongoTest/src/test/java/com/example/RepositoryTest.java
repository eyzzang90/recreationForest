package com.example;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.mongo.config.ApplicationConfig;

import com.example.domain.RecreationForest;
import com.example.repository.RecreationForestRepository;

@EnableMongoRepositories(basePackages = "com.example.repository")
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:*/templates/context/context-mongo.xml", "classpath:*/templates/context/context-mongo.xml"})
//@ContextConfiguration("classpath:*/templates/context/context-mongo.xml")
@ContextConfiguration("/templates/context/context-mongo.xml")
//@ContextConfiguration(classes = {ApplicationConfig.class})
@ActiveProfiles("local")
public class RepositoryTest {

//	ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//	MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
	
//	@Qualifier(value = "recreationForestRepository")
	@Autowired
	RecreationForestRepository recreationForestRepository;
	
	static Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
	
	@Test
	public void test(){
		
		mongoLogger.setLevel(Level.SEVERE);
		
		PageRequest pageReq = new PageRequest(1, 10, new Sort(Direction.DESC, "name"));
		
		System.out.println("0");
//		List<RecreationForest> list =  (List<RecreationForest>) recreationForestRepository.findAll();
//		List<RecreationForest> list = recreationForestRepository.findAll();
//		List<RecreationForest> list =  recreationForestRepository.findByName("주천강자연휴양림");
		
		List<RecreationForest> list =  recreationForestRepository.findByCpCode("033", pageReq).getContent();
	
		
		
		System.out.println("1");
		
		if(list ==null){
			System.out.println("2");
			System.out.println("null");
		}else{
			System.out.println("3");
			for(RecreationForest recreationForest : list){
				System.out.println(recreationForest.toString());
			}
			System.out.println(">" + list.size());
		}
		
		System.out.println("end");
	}
	
	
}

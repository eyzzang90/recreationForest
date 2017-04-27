package com.example.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.repository.RecreationForestRepository;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableMongoRepositories(basePackageClasses = {RecreationForestRepository.class})
//public class ApplicationConfig {
	public class ApplicationConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "test";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}
	
	@Override
	protected String getMappingBasePackage(){
		return "com.example.domain";
	}

//	@Bean
//	public MongoTemplate mongoTemplate(){
//		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"), "test");
//		return mongoTemplate;
//	}
	
	
}

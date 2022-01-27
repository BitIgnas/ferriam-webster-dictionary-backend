package com.ferrianwebsterdictionary.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@EnableMongoRepositories("com.ferrianwebsterdictionary.app.demo.repo")
public class FerrianWebsterDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerrianWebsterDictionaryApplication.class, args);
	}

}

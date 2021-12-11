package com.ferrianwebsterdictionary.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.ferrianwebsterdictionary.app.demo.repo")
public class FerrianWebsterDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FerrianWebsterDictionaryApplication.class, args);
	}

}

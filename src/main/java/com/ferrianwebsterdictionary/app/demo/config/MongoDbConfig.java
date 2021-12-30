package com.ferrianwebsterdictionary.app.demo.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Objects;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {

    private final Environment environment;

    public MongoDbConfig(Environment environment) {
        this.environment = environment;
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(Objects.requireNonNull(environment.getProperty("spring.data.mongodb.uri")));
    }

    @Override
    protected String getDatabaseName() {
        return environment.getProperty("active.mongodb.db");
    }




}

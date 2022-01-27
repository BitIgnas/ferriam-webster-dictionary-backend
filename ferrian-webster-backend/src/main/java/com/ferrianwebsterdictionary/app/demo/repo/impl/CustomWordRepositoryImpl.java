package com.ferrianwebsterdictionary.app.demo.repo.impl;

import com.ferrianwebsterdictionary.app.demo.model.CustomWord;
import com.ferrianwebsterdictionary.app.demo.repo.CustomWordRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomWordRepositoryImpl implements CustomWordRepository {

    private final MongoTemplate mongoTemplate;

    public CustomWordRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<CustomWord> findByName(String name) {
        Query query = new Query().addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.find(query, CustomWord.class);
    }

    @Override
    public List<CustomWord> findByWordByRegex(String regexPart) {
        Query query = new Query().addCriteria(Criteria.where("name").regex(regexPart, "i"));

        return mongoTemplate.find(query, CustomWord.class);
    }




}

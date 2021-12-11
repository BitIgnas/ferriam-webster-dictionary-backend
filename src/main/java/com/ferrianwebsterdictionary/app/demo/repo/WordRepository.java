package com.ferrianwebsterdictionary.app.demo.repo;

import com.ferrianwebsterdictionary.app.demo.model.CustomWord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends MongoRepository<CustomWord, String>, CustomWordRepository {
}

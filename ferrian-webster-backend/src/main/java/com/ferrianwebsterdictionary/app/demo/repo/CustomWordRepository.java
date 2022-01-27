package com.ferrianwebsterdictionary.app.demo.repo;

import com.ferrianwebsterdictionary.app.demo.model.CustomWord;

import java.util.List;

public interface CustomWordRepository {
    List<CustomWord> findByName(String name);
    List<CustomWord> findByWordByRegex(String part);
}

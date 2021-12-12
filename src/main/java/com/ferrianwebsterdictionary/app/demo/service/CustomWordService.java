package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.CustomWordRequest;
import com.ferrianwebsterdictionary.app.demo.dto.CustomWordResponse;
import com.ferrianwebsterdictionary.app.demo.model.CustomWord;

import java.util.List;

public interface CustomWordService {

    CustomWordResponse saveWord(CustomWordRequest customWordRequest);
    List<CustomWordResponse> findAllWords();
    List<CustomWordResponse> findByWordByRegex(String regex);
    List<CustomWordResponse> findWordByName(String name);
    CustomWordResponse mapToCustomWordResponse(CustomWord customWord);
    CustomWord mapToCustomWord(CustomWordRequest customWordRequest);
}

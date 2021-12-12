package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.ApiWordResponse;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface ApiDictionaryService {
    List<ApiWordResponse> getWordDefinition(String word);
    List<ApiWordResponse> getWordDefinitionWithPartOfSpeech(String word, String partOfSpeech);
    List<String> getAllWordSynonyms(String word);
    HttpEntity<String> createHttpEntity();
}

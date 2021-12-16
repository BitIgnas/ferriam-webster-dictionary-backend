package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.ApiWordResponse;
import org.springframework.http.HttpEntity;

import java.util.List;
import java.util.Map;

public interface ApiDictionaryService {
    Map<Integer, ApiWordResponse> getWordDefinition(String word);
    List<ApiWordResponse> getWordDefinitionWithPartOfSpeech(String word, String partOfSpeech);
    ApiWordResponse getSelectMeaningOfWordDefinition(String word, Integer meaningNum);
    List<String> getAllWordSynonyms(String word);
    Map<Integer, ApiWordResponse> mapResponseToMeaningMap(List<ApiWordResponse> definitions);
    HttpEntity<String> createHttpEntity();
}

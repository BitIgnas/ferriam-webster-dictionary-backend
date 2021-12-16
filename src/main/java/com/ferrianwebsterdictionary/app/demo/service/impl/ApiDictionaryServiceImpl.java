package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.dto.ApiWordResponse;
import com.ferrianwebsterdictionary.app.demo.errorHandler.ApiDictionaryRestTemplateResponseErrorHandler;
import com.ferrianwebsterdictionary.app.demo.exception.NoWordFoundInMeaningIndexException;
import com.ferrianwebsterdictionary.app.demo.model.Definition;
import com.ferrianwebsterdictionary.app.demo.model.Meaning;
import com.ferrianwebsterdictionary.app.demo.service.ApiDictionaryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ApiDictionaryServiceImpl implements ApiDictionaryService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public ApiDictionaryServiceImpl(RestTemplate restTemplate, RestTemplateBuilder restTemplateBuilder, Environment environment) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new ApiDictionaryRestTemplateResponseErrorHandler())
                .build();
        this.environment = environment;
    }

    @Override
    public Map<Integer, ApiWordResponse> getWordDefinition(String word) {
        ResponseEntity<ApiWordResponse[]> response = restTemplate.exchange(
                Objects.requireNonNull(environment.getProperty("api.dictionary.url")).concat(word),
                HttpMethod.GET,
                createHttpEntity(),
                ApiWordResponse[].class
        );


        return mapResponseToMeaningMap(List.of(Objects.requireNonNull(response.getBody())));
    }


    @Override
    public List<ApiWordResponse> getWordDefinitionWithPartOfSpeech(String word, String partOfSpeech) {
        ResponseEntity<ApiWordResponse[]> response = restTemplate.exchange(
                Objects.requireNonNull(environment.getProperty("api.dictionary.url")).concat(word),
                HttpMethod.GET,
                createHttpEntity(),
                ApiWordResponse[].class
        );

        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .filter(wordMeaning -> wordMeaning.getMeanings().stream()
                        .anyMatch(part -> part.getPartOfSpeech().equals(partOfSpeech)))
                .collect(Collectors.toList());

    }

    @Override
    public ApiWordResponse getSelectMeaningOfWordDefinition(String word, Integer meaningNum) {
        ResponseEntity<ApiWordResponse[]> response = restTemplate.exchange(
                Objects.requireNonNull(environment.getProperty("api.dictionary.url")).concat(word),
                HttpMethod.GET,
                createHttpEntity(),
                ApiWordResponse[].class
        );

        Map<Integer, ApiWordResponse> wordMeaningMap = mapResponseToMeaningMap(List.of(Objects.requireNonNull(response.getBody())));

        return Optional.ofNullable(wordMeaningMap.get(meaningNum)).orElseThrow(() ->
                new NoWordFoundInMeaningIndexException(String.format("Word: %s doesn't have meaning at index: %d", word, meaningNum)));
    }

    @Override
    public List<String> getAllWordSynonyms(String word) {
        ResponseEntity<ApiWordResponse[]> response = restTemplate.exchange(
                Objects.requireNonNull(environment.getProperty("api.dictionary.url")).concat(word),
                HttpMethod.GET,
                createHttpEntity(),
                ApiWordResponse[].class
        );

        return Arrays.stream(Objects.requireNonNull(response.getBody()))
                .map(ApiWordResponse::getMeanings)
                .flatMap(Collection::stream)
                .map(Meaning::getDefinitions)
                .flatMap(Collection::stream)
                .map(Definition::getSynonyms)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, ApiWordResponse> mapResponseToMeaningMap(List<ApiWordResponse> definitions) {
        Map<Integer, ApiWordResponse> definitionMap = new HashMap<>();
        AtomicInteger count = new AtomicInteger(0);

        definitions.stream().forEach(def -> {
            definitionMap.put(count.incrementAndGet(), def);
        });

        return definitionMap;
    }

    @Override
    public HttpEntity<String> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setAllow(Set.of(HttpMethod.GET));

        return new HttpEntity<>(httpHeaders);
    }


}

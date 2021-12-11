package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.dto.ApiWordResponse;
import com.ferrianwebsterdictionary.app.demo.exception.ApiDictionaryWordNotFoundException;
import com.ferrianwebsterdictionary.app.demo.model.Definition;
import com.ferrianwebsterdictionary.app.demo.model.Meaning;
import com.ferrianwebsterdictionary.app.demo.service.ApiWordService;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApiWordServiceImpl implements ApiWordService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public ApiWordServiceImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public List<ApiWordResponse> getWordDefinition(String word) {
        ResponseEntity<ApiWordResponse[]> response = restTemplate.exchange(
                Objects.requireNonNull(environment.getProperty("api.dictionary.url")).concat(word),
                HttpMethod.GET,
                createHttpEntity(),
                ApiWordResponse[].class
        );


        return List.of(Objects.requireNonNull(response.getBody()));
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
    public HttpEntity<String> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setAllow(Set.of(HttpMethod.GET));

        return new HttpEntity<>(httpHeaders);
    }


}

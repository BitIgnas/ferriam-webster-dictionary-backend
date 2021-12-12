package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ferrianwebsterdictionary.app.demo.deserializer.TranslatedJsonWordDeserializer;
import com.ferrianwebsterdictionary.app.demo.dto.ApiTranslationRequest;
import com.ferrianwebsterdictionary.app.demo.dto.ApiTranslationResponse;
import com.ferrianwebsterdictionary.app.demo.service.ApiTranslationService;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiTranslationServiceImpl implements ApiTranslationService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public ApiTranslationServiceImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public ApiTranslationResponse translate(ApiTranslationRequest apiTranslationRequest) {
        String url = String.format(
                "%s?text=%s&to=%s&from=%s",
                environment.getProperty("translator.rapid.api.url"),
                apiTranslationRequest.getText(),
                apiTranslationRequest.getTo(),
                apiTranslationRequest.getFrom());

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                createHttpEntity(),
                String.class
        );

        return mapFromJsonToResponse(response.getBody());
    }

    @Override
    public HttpEntity<String> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-host", environment.getProperty("translator.rapid.api.host"));
        httpHeaders.set("x-rapidapi-key", environment.getProperty("translator.rapid.api.key"));

        return new HttpEntity<>(httpHeaders);
    }

    @Override
    public ApiTranslationResponse mapFromJsonToResponse(String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomWordDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(ApiTranslationResponse.class, new TranslatedJsonWordDeserializer());
        mapper.registerModule(module);

        try {
            return mapper.readValue(json, ApiTranslationResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}

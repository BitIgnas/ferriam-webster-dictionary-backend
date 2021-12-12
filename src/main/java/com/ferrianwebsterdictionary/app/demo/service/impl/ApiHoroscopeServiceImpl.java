package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.dto.ApiHoroscopeResponse;
import com.ferrianwebsterdictionary.app.demo.service.ApiHoroscopeService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiHoroscopeServiceImpl implements ApiHoroscopeService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    public ApiHoroscopeServiceImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @Override
    public ApiHoroscopeResponse getHoroscope(String sign, String day) {
        String url = String.format("%s/?sign=%s&day=%s", environment.getProperty("horoscope.rapid.api.url"), sign, day);

        ResponseEntity<ApiHoroscopeResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                createHttpEntity(),
                ApiHoroscopeResponse.class
        );

        return responseEntity.getBody();
    }

    @Override
    public HttpEntity<String> createHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-rapidapi-host", environment.getProperty("horoscope.rapid.api.host"));
        httpHeaders.set("x-rapidapi-key", environment.getProperty("translator.rapid.api.key"));

        return new HttpEntity<>(httpHeaders);
    }
}

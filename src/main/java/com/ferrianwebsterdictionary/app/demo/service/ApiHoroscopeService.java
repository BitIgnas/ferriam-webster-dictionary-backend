package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.ApiHoroscopeResponse;
import org.springframework.http.HttpEntity;

public interface ApiHoroscopeService {
    ApiHoroscopeResponse getHoroscope(String sign, String day);
    HttpEntity<String> createHttpEntity();
}

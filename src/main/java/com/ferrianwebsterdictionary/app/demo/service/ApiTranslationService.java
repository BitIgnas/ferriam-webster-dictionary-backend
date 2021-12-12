package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.ApiTranslationRequest;
import com.ferrianwebsterdictionary.app.demo.dto.ApiTranslationResponse;
import org.springframework.http.HttpEntity;

public interface ApiTranslationService {
    ApiTranslationResponse translate(ApiTranslationRequest apiTranslationRequest);
    ApiTranslationResponse mapFromJsonToResponse(String json);
    HttpEntity<String> createHttpEntity();
}

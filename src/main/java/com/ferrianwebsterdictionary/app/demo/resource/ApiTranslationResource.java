package com.ferrianwebsterdictionary.app.demo.resource;

import com.ferrianwebsterdictionary.app.demo.dto.ApiTranslationRequest;
import com.ferrianwebsterdictionary.app.demo.dto.ApiTranslationResponse;
import com.ferrianwebsterdictionary.app.demo.service.ApiTranslationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/translate")
public class ApiTranslationResource {

    private final ApiTranslationService apiTranslationService;


    public ApiTranslationResource(ApiTranslationService apiTranslationService) {
        this.apiTranslationService = apiTranslationService;
    }

    @GetMapping("/word")
    public ApiTranslationResponse getTranslation(@RequestBody ApiTranslationRequest apiTranslationRequest) {
        return apiTranslationService.translate(apiTranslationRequest);
    }
}

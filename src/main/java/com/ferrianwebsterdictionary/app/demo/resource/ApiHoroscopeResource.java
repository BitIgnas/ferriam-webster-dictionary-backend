package com.ferrianwebsterdictionary.app.demo.resource;

import com.ferrianwebsterdictionary.app.demo.dto.ApiHoroscopeResponse;
import com.ferrianwebsterdictionary.app.demo.service.ApiHoroscopeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/horoscope")
public class ApiHoroscopeResource {

    private final ApiHoroscopeService apiHoroscopeService;

    public ApiHoroscopeResource(ApiHoroscopeService apiHoroscopeService) {
        this.apiHoroscopeService = apiHoroscopeService;
    }

    @PostMapping("/{horoscope}/{day}")
    public ResponseEntity<ApiHoroscopeResponse> getHoroscope(@PathVariable("horoscope") String horoscope,
                                                             @PathVariable("day") String day) {
        return ResponseEntity.ok().body(apiHoroscopeService.getHoroscope(horoscope, day));

    }

}

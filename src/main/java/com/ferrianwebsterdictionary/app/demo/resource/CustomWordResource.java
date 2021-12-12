package com.ferrianwebsterdictionary.app.demo.resource;

import com.ferrianwebsterdictionary.app.demo.dto.CustomWordRequest;
import com.ferrianwebsterdictionary.app.demo.dto.CustomWordResponse;
import com.ferrianwebsterdictionary.app.demo.service.CustomWordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/custom-word")
public class CustomWordResource {

    private final CustomWordService customWordService;

    public CustomWordResource(CustomWordService customWordService) {
        this.customWordService = customWordService;
    }

    @PostMapping("/")
    public ResponseEntity<CustomWordResponse> saveCustomWord(@RequestBody CustomWordRequest customWordRequest) {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v2/custom-word/").toUriString());
        return ResponseEntity.created(location).body(customWordService.saveWord(customWordRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomWordResponse>> getAllCustomWords() {
        return ResponseEntity.ok().body(customWordService.findAllWords());
    }

    @GetMapping("/regex/{regex}")
    public ResponseEntity<List<CustomWordResponse>> getAllWordsByRegex(@PathVariable("regex") String regex) {
        return ResponseEntity.ok().body(customWordService.findByWordByRegex(regex));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomWordResponse>> getAllWordsByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(customWordService.findWordByName(name));
    }



}

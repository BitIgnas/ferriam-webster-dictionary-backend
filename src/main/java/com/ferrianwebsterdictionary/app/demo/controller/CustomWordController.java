package com.ferrianwebsterdictionary.app.demo.controller;

import com.ferrianwebsterdictionary.app.demo.dto.CustomWordRequestDto;
import com.ferrianwebsterdictionary.app.demo.dto.CustomWordResponseDto;
import com.ferrianwebsterdictionary.app.demo.service.CustomWordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/custom-word")
public class CustomWordController {

    private final CustomWordService customWordService;

    public CustomWordController(CustomWordService customWordService) {
        this.customWordService = customWordService;
    }

    @PostMapping("/")
    public ResponseEntity<CustomWordResponseDto> saveCustomWord(@RequestBody CustomWordRequestDto customWordRequestDto) {
        URI location = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v2/custom-word/").toUriString());
        return ResponseEntity.created(location).body(customWordService.saveWord(customWordRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomWordResponseDto>> getAllCustomWords() {
        return ResponseEntity.ok().body(customWordService.findAllWords());
    }

    @GetMapping("/regex/{regex}")
    public ResponseEntity<List<CustomWordResponseDto>> getAllWordsByRegex(@PathVariable("regex") String regex) {
        return ResponseEntity.ok().body(customWordService.findByWordByRegex(regex));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomWordResponseDto>> getAllWordsByName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(customWordService.findWordByName(name));
    }



}

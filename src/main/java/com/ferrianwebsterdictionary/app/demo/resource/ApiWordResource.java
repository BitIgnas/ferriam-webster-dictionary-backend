package com.ferrianwebsterdictionary.app.demo.resource;

import com.ferrianwebsterdictionary.app.demo.dto.ApiWordResponse;
import com.ferrianwebsterdictionary.app.demo.service.ApiDictionaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v2/word")
public class ApiWordResource {

    private final ApiDictionaryService apiDictionaryService;

    public ApiWordResource(ApiDictionaryService apiDictionaryService) {
        this.apiDictionaryService = apiDictionaryService;
    }

    @GetMapping(value = "/find/{word}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApiWordResponse>> getWordDefinition(@PathVariable("word") String word) {
        return ResponseEntity.ok().body(apiDictionaryService.getWordDefinition(word));
    }

    @GetMapping(value = "/find/{word}/{partOfSpeech}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApiWordResponse>> getWordDefinitionsWithPartOfSpeech(@PathVariable("word") String word,
                                                                                    @PathVariable("partOfSpeech") String partOfSpeech) {
        return ResponseEntity.ok().body(apiDictionaryService.getWordDefinitionWithPartOfSpeech(word, partOfSpeech));
    }

    @GetMapping(value = "/find/{word}/synonyms", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getWordSynonyms(@PathVariable("word") String word) {
        return ResponseEntity.ok().body(apiDictionaryService.getAllWordSynonyms(word));
    }

}

package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.dto.CustomWordRequest;
import com.ferrianwebsterdictionary.app.demo.dto.CustomWordResponse;
import com.ferrianwebsterdictionary.app.demo.model.CustomWord;
import com.ferrianwebsterdictionary.app.demo.repo.WordRepository;
import com.ferrianwebsterdictionary.app.demo.service.CustomWordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomWordServiceImpl implements CustomWordService {

    private final WordRepository wordRepository;

    public CustomWordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public CustomWordResponse saveWord(CustomWordRequest customWordRequest) {
        return mapToCustomWordResponse(wordRepository.save(mapToCustomWord(customWordRequest)));
    }

    @Override
    public List<CustomWordResponse> findAllWords() {
        return wordRepository.findAll().stream()
                .map(this::mapToCustomWordResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomWordResponse> findByWordByRegex(String regex) {
        return wordRepository.findByWordByRegex(regex).stream()
                .map(this::mapToCustomWordResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomWordResponse> findWordByName(String name) {
        return wordRepository.findByName(name).stream()
                .map(this::mapToCustomWordResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomWordResponse mapToCustomWordResponse(CustomWord customWord) {
        CustomWordResponse customWordResponse = new CustomWordResponse();
        customWordResponse.setWord(customWord.getWord());
        customWordResponse.setMeaning(customWord.getMeaning());
        customWordResponse.setOrigin(customWord.getOrigin());
        customWordResponse.setNounType(customWord.getNounType());

        return customWordResponse;
    }

    @Override
    public CustomWord mapToCustomWord(CustomWordRequest customWordRequest) {
        CustomWord customWord = new CustomWord();
        customWord.setWord(customWordRequest.getWord());
        customWord.setMeaning(customWordRequest.getMeaning());
        customWord.setOrigin(customWordRequest.getOrigin());
        customWord.setNounType(customWordRequest.getNounType());

        return customWord;
    }
}

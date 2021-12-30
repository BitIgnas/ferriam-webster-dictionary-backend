package com.ferrianwebsterdictionary.app.demo.service.impl;

import com.ferrianwebsterdictionary.app.demo.dto.CustomWordRequestDto;
import com.ferrianwebsterdictionary.app.demo.dto.CustomWordResponseDto;
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
    public CustomWordResponseDto saveWord(CustomWordRequestDto customWordRequestDto) {
        return mapToCustomWordResponse(wordRepository.save(mapToCustomWord(customWordRequestDto)));
    }

    @Override
    public List<CustomWordResponseDto> findAllWords() {
        return wordRepository.findAll().stream()
                .map(this::mapToCustomWordResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomWordResponseDto> findByWordByRegex(String regex) {
        return wordRepository.findByWordByRegex(regex).stream()
                .map(this::mapToCustomWordResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomWordResponseDto> findWordByName(String name) {
        return wordRepository.findByName(name).stream()
                .map(this::mapToCustomWordResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomWordResponseDto mapToCustomWordResponse(CustomWord customWord) {
        CustomWordResponseDto customWordResponseDto = new CustomWordResponseDto();
        customWordResponseDto.setWord(customWord.getWord());
        customWordResponseDto.setMeaning(customWord.getMeaning());
        customWordResponseDto.setOrigin(customWord.getOrigin());
        customWordResponseDto.setNounType(customWord.getNounType());

        return customWordResponseDto;
    }

    @Override
    public CustomWord mapToCustomWord(CustomWordRequestDto customWordRequestDto) {
        CustomWord customWord = new CustomWord();
        customWord.setWord(customWordRequestDto.getWord());
        customWord.setMeaning(customWordRequestDto.getMeaning());
        customWord.setOrigin(customWordRequestDto.getOrigin());
        customWord.setNounType(customWordRequestDto.getNounType());

        return customWord;
    }
}

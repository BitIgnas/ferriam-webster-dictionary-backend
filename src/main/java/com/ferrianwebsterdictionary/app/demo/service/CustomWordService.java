package com.ferrianwebsterdictionary.app.demo.service;

import com.ferrianwebsterdictionary.app.demo.dto.CustomWordRequestDto;
import com.ferrianwebsterdictionary.app.demo.dto.CustomWordResponseDto;
import com.ferrianwebsterdictionary.app.demo.model.CustomWord;

import java.util.List;

public interface CustomWordService {

    CustomWordResponseDto saveWord(CustomWordRequestDto customWordRequestDto);
    List<CustomWordResponseDto> findAllWords();
    List<CustomWordResponseDto> findByWordByRegex(String regex);
    List<CustomWordResponseDto> findWordByName(String name);
    CustomWordResponseDto mapToCustomWordResponse(CustomWord customWord);
    CustomWord mapToCustomWord(CustomWordRequestDto customWordRequestDto);
}

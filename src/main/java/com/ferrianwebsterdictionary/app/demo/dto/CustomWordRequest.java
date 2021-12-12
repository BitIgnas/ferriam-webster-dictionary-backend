package com.ferrianwebsterdictionary.app.demo.dto;

import com.ferrianwebsterdictionary.app.demo.model.NounType;
import org.springframework.data.mongodb.core.mapping.Field;

public class CustomWordRequest {

    private String word;
    private String meaning;
    private String origin;
    private String phonetic;
    private NounType nounType;

    public CustomWordRequest(String word, String meaning, String origin, String phonetic, NounType nounType) {
        this.word = word;
        this.meaning = meaning;
        this.origin = origin;
        this.phonetic = phonetic;
        this.nounType = nounType;
    }

    public CustomWordRequest() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public NounType getNounType() {
        return nounType;
    }

    public void setNounType(NounType nounType) {
        this.nounType = nounType;
    }
}

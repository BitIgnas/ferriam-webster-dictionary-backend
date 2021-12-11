package com.ferrianwebsterdictionary.app.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class CustomWord {

    @Id
    private String id;
    private String word;
    private String meaning;
    private String origin;
    private String phonetic;
    @Field(name = "nounType")
    private NounType nounType;

    public CustomWord(String id, String word, String meaning, String origin, NounType nounType) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.origin = origin;
        this.nounType = nounType;
    }

    public CustomWord() {

    }

    public String getId() {
        return id;
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

    public NounType getNounType() {
        return nounType;
    }

    public void setNounType(NounType nounType) {
        this.nounType = nounType;
    }
}

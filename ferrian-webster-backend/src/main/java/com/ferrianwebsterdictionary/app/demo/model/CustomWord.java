package com.ferrianwebsterdictionary.app.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

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
    private Instant createdAt;

    public CustomWord(String id, String word, String meaning, String origin, String phonetic, NounType nounType, Instant createdAt) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.origin = origin;
        this.phonetic = phonetic;
        this.nounType = nounType;
        this.createdAt = createdAt;
    }

    public CustomWord() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}

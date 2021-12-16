package com.ferrianwebsterdictionary.app.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public class StoredWord {

    @Id
    private String word;
    private String meaning;
    private String phonetic;
    private Instant savedAt;

    public StoredWord(String word, String meaning, String phonetic, Instant savedAt) {
        this.word = word;
        this.meaning = meaning;
        this.phonetic = phonetic;
        this.savedAt = savedAt;
    }

    public StoredWord() {
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

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public Instant getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(Instant savedAt) {
        this.savedAt = savedAt;
    }
}

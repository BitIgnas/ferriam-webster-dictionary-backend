package com.ferrianwebsterdictionary.app.demo.model;

import java.util.List;

public class Definition {
    private String definition;
    private List<String> synonyms;
    private List<String> antonyms;

    public Definition(String definition, List<String> synonyms, List<String> antonyms) {
        this.definition = definition;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }

    public Definition() {
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public List<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<String> antonyms) {
        this.antonyms = antonyms;
    }
}

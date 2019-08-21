package com.example.U1M4SummativeLoraBrian.model;

public class Word {
    private String word;
    private String definition;

    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public Word() {
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

}

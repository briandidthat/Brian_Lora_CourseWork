package com.example.U1M4SummativeLoraBrian.model;

import java.util.HashMap;
import java.util.Map;

public class Word {
    private Map<String, String> wordsOfTheDay = new HashMap<>();

    public void setWordsOfTheDay(Map<String, String> wordsOfTheDay) {
        this.wordsOfTheDay = wordsOfTheDay;
    }

    public Map<String, String> getWordsOfTheDay() {
        return wordsOfTheDay;
    }

}

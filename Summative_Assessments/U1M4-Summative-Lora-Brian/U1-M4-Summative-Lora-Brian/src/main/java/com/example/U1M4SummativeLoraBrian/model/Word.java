package com.example.U1M4SummativeLoraBrian.model;


import java.util.*;

public class Word {
    private List<String> wordsList;

    public int getRandom() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }


    public void setWordsList(List<String> wordsList) {
        this.wordsList = wordsList;
    }
}

package com.example.U1M4SummativeLoraBrian.model;

import java.util.HashMap;


public class WordMap {
    private HashMap<Integer, Word> words;

    public WordMap() {
        words = new HashMap<>();
        populateWordMap();
    }

    public void populateWordMap() {
        Word word1 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word2 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word3 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word4 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word5 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word6 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word7 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word8 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word9 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Word word10 = new Word("You miss 100% of the shots you don’t take.", "Wayne Gretzky");

        addWord(1,word1);
        addWord(2,word2);
        addWord(3,word3);
        addWord(4,word4);
        addWord(5,word5);
        addWord(6,word6);
        addWord(7,word7);
        addWord(8,word8);
        addWord(9,word9);
        addWord(10,word10);
    }

    public Word getWord(int n) {
        return words.get(n);
    }

    public void addWord(int i, Word word) {
        words.put(i, word);
    }
}

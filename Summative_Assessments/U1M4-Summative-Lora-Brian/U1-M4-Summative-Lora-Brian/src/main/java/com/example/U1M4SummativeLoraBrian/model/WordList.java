package com.example.U1M4SummativeLoraBrian.model;

import java.util.ArrayList;
import java.util.List;


public class WordList {
    private List<Word> words;

    public WordList() {
        words = new ArrayList<>();
        populateWordList();
    }

    public void populateWordList() {
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

        addWord(word1);
        addWord(word2);
        addWord(word3);
        addWord(word4);
        addWord(word5);
        addWord(word6);
        addWord(word7);
        addWord(word8);
        addWord(word9);
        addWord(word10);
    }

    public Word getWord(int n) {
        if (n == 10) {
            n-= 1;
        }
        return words.get(n);
    }

    public void addWord(Word word) {
        words.add(word);
    }
}

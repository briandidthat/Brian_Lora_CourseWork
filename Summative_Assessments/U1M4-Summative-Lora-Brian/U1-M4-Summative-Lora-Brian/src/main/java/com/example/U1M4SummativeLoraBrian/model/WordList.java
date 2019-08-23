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
        Word word1 = new Word("Matrix", " A rectangular array of numbers (or symbols standing for " +
                "numbers). An m × n matrix is a matrix with m rows and n columns.");
        Word word2 = new Word("Quixotic", "extravagantly chivalrous or romantic; visionary, " +
                "impractical, or impracticable.");
        Word word3 = new Word("Liminal.", "relating to a transitional or initial stage of a process.");
        Word word4 = new Word("Esoteric", "intended for or likely to be understood by only a small " +
                "number of people with a specialized knowledge or interest.");
        Word word5 = new Word("Numinous", "having a strong religious or spiritual quality; " +
                "indicating or suggesting the presence of a divinity.");
        Word word6 = new Word("Loquacious", "tending to talk a great deal; talkative.");
        Word word7 = new Word("Transient", "lasting only for a short time; impermanent.");
        Word word8 = new Word("Elysian", "relating to or characteristic of heaven or paradise.");
        Word word9 = new Word("Logarithm", "a quantity representing the power to which a fixed " +
                "number (the base) must be raised to produce a given number.");
        Word word10 = new Word("Scalar", " an element of a field, which is used to define a vector " +
                "space, usually the field of real numbers");

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
            n -= 1;
        }
        return words.get(n);
    }

    public void addWord(Word word) {
        words.add(word);
    }
}

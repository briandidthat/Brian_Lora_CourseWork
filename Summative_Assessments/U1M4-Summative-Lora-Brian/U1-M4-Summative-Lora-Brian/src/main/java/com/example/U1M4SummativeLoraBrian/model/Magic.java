package com.example.U1M4SummativeLoraBrian.model;

import java.util.ArrayList;
import java.util.List;


public class Magic {
    private List<String> answers = new ArrayList<>();
    private List<String> questions = new ArrayList<>();

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void addAnswer(String answer) {
        this.answers.add(answer);
    }

    public void addQuestion(String question) {
        this.answers.add(question);
    }
}

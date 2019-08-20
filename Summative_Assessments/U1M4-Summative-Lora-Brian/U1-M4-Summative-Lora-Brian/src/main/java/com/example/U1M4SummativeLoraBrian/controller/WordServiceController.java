package com.example.U1M4SummativeLoraBrian.controller;

import com.example.U1M4SummativeLoraBrian.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WordServiceController {
    @GetMapping(value = "/word")
    @ResponseStatus(value = HttpStatus.OK)
    public String getWord() {
        return "hey";
    }


    public int getRandom() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }


}
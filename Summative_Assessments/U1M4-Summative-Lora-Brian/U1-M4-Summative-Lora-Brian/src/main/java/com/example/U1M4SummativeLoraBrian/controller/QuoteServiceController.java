package com.example.U1M4SummativeLoraBrian.controller;

import com.example.U1M4SummativeLoraBrian.model.Quote;
import com.example.U1M4SummativeLoraBrian.model.QuoteMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QuoteServiceController {

    @GetMapping(value = "/quote")
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {
        QuoteMap quotes = new QuoteMap();
        return quotes.getQuote(generateRandom());
    }

    public int generateRandom() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

}
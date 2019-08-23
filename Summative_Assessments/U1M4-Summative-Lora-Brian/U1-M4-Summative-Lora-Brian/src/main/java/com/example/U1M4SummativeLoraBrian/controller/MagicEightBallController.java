package com.example.U1M4SummativeLoraBrian.controller;

import com.example.U1M4SummativeLoraBrian.model.Magic;
import com.example.U1M4SummativeLoraBrian.model.MagicList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class MagicEightBallController {

    @PostMapping(value = "/magic")
    @ResponseStatus(value = HttpStatus.OK)
    public Magic postQuestion(@RequestBody String question) {
        MagicList magicList = new MagicList();
        Magic magic = new Magic();

        int randomId = generateRandom();
        magic.setQuestion(question);
        magicList.updateListElement(randomId, magic);

        return magicList.getMagic(randomId);
    }

    private int generateRandom() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }
}
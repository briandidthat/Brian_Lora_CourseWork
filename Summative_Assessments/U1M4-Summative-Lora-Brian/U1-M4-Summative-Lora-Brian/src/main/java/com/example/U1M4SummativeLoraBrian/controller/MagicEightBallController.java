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
        Magic magic = magicList.getMagic(generateRandom());
        magic.setQuestion(question);

        return magic;
    }

    private int generateRandom() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }
}
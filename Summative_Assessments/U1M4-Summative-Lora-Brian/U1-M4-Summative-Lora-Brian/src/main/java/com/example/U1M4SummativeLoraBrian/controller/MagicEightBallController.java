package com.example.U1M4SummativeLoraBrian.controller;

import com.example.U1M4SummativeLoraBrian.model.Magic;
import com.example.U1M4SummativeLoraBrian.model.MagicList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
public class MagicEightBallController {

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Magic postQuestion(@RequestBody String question) {
        MagicList magicList = new MagicList();
        Magic magic = magicList.getMagic(generateRandom());
        // is there  a better way to achieve this so that I dont have to do all of this voodoo? If so,
        // please provide a link or a method name. Thank you!

        question = question.replaceAll("\\{", "").replaceAll("\\}","")
                .replaceAll("question", "").replaceAll("\"", "")
                .replaceAll(":", "");
        question = question.trim();
        magic.setQuestion(question);

        System.out.println(question);

        return magic;
    }

    private int generateRandom() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }
}
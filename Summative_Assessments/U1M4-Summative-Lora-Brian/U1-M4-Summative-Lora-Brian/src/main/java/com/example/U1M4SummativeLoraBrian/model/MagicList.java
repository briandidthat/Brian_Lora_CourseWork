package com.example.U1M4SummativeLoraBrian.model;

import java.util.ArrayList;
import java.util.List;

/*Task:
 *
 */
public class MagicList {
    private List<Magic> magicEightBallList;

    public MagicList() {
        magicEightBallList = new ArrayList<>();
        populateList();
    }

    public void populateList() {
        Magic magic1 = new Magic();
        Magic magic2 = new Magic();
        Magic magic3 = new Magic();
        Magic magic4 = new Magic();
        Magic magic5 = new Magic();
        Magic magic6 = new Magic();
        Magic magic7 = new Magic();
        Magic magic8 = new Magic();
        Magic magic9 = new Magic();
        Magic magic10 = new Magic();

        magic1.setAnswer("It is certain.");
        magic2.setAnswer("My sources say no.");
        magic3.setAnswer("Concentrate and ask again");
        magic4.setAnswer("As I see it, yes.");
        magic5.setAnswer("Reply hazy, try again.");
        magic6.setAnswer("Signs point to yes");
        magic7.setAnswer("Outlook not so good.");
        magic8.setAnswer("Most likely.");
        magic9.setAnswer("Cannot predict now.");
        magic10.setAnswer("Very doubtful.");

        magicEightBallList.add(magic1);
        magicEightBallList.add(magic2);
        magicEightBallList.add(magic3);
        magicEightBallList.add(magic4);
        magicEightBallList.add(magic5);
        magicEightBallList.add(magic6);
        magicEightBallList.add(magic7);
        magicEightBallList.add(magic8);
        magicEightBallList.add(magic9);
        magicEightBallList.add(magic10);

    }

    public void updateListElement(int index, Magic magic) {
        magicEightBallList.set(index, magic);
    }

    public Magic getMagic(int idx) {
        return magicEightBallList.get(idx);
    }
}

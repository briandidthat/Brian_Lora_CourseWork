package com.example.U1M4SummativeLoraBrian.model;

import java.util.ArrayList;
import java.util.List;

public class QuoteList {

    private List<Quote> quotes;

    public QuoteList() {
        quotes = new ArrayList<>();
        populateQuotesMap();
    }

    public void populateQuotesMap() {
        Quote quote1 = new Quote("You miss 100% of the shots you don’t take.", "Wayne Gretzky");
        Quote quote2 = new Quote("Strive not to be a success, but rather to be of value.",
                "Albert Einstein");
        Quote quote3 = new Quote("I attribute my success to this: I never gave or took any excuse.",
                "Florence Nightingale");
        Quote quote4 = new Quote("The two most important days in your life are the day you are born and " +
                "the day you find out why", "Mark Twain");
        Quote quote5 = new Quote("Either you run the day, or the day runs you.", "Jim Rohn");
        Quote quote6 = new Quote("Everything you’ve ever wanted is on the other side of fear.",
                "Wayne Gretzky");
        Quote quote7 = new Quote("We can easily forgive a child who is afraid of the dark; the real tragedy " +
                "of life is when men are afraid of the light. ", "Plato");
        Quote quote8 = new Quote("When I let go of what I am, I become what I might be. ", "Wayne Gretzky");
        Quote quote9 = new Quote("I would rather die of passion than of boredom.", "Vincent Van Gogh");
        Quote quote10 = new Quote("Any fool can know. The point is to understand", "Albert Einstein");

        addQuote(quote1);
        addQuote(quote2);
        addQuote(quote3);
        addQuote(quote4);
        addQuote(quote5);
        addQuote(quote6);
        addQuote(quote7);
        addQuote(quote8);
        addQuote(quote9);
        addQuote(quote10);
    }

    public Quote getQuote(int n) {
        if (n == 10) {
            n -= 1;
        }
        return quotes.get(n);
    }

    public void addQuote(Quote quote) {
        quotes.add(quote);
    }
}

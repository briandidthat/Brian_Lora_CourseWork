package com.example.U1M4SummativeLoraBrian.model;

import java.util.HashMap;
import java.util.Map;

/*Task:
 *
 */
public class QuoteMap {
    // Map to store quotes. Logic behind the decision to use this data type:
    // The order of the elements is not important to me as we are serving them randomly. In that case,
    // since order doesn't matter, I can use a map since it is faster to query since it doesn't have to walk through the
    // entire array. I could be wrong, and would appreciate feedback -- I know it's a small app and performance isn't
    // our primary concern, but I feel I should make a conscious effort to monitor performance to create habits.

    private Map<Integer, Quote> quotes;

    public QuoteMap() {
        quotes = new HashMap<>();
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

        addQuote(1,quote1);
        addQuote(2,quote2);
        addQuote(3,quote3);
        addQuote(4,quote4);
        addQuote(5,quote5);
        addQuote(6,quote6);
        addQuote(7,quote7);
        addQuote(8,quote8);
        addQuote(9,quote9);
        addQuote(10,quote10);
    }

    public Quote getQuote(int n) {
        return quotes.get(n);
    }

    public void addQuote(int i, Quote quote) {
        quotes.put(i, quote);
    }
}

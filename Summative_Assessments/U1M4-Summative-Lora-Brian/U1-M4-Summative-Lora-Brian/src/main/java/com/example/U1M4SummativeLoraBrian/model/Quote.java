package com.example.U1M4SummativeLoraBrian.model;

/*Task:
 *
 */
public class Quote {
    private String quote;
    private String author;

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public Quote() {
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }


}

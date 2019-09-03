package com.company.BrianLoraU1Capstone.model;


import java.math.BigDecimal;
import java.util.Objects;

public class Game {
    private int gameId;
    private String title;
    private String esrbRating;
    private String description;
    private BigDecimal price;
    private String studio;
    private int quantity;

    // SETTERS
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // GETTERS
    public int getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getStudio() {
        return studio;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getGameId() == game.getGameId() &&
                getQuantity() == game.getQuantity() &&
                Objects.equals(getTitle(), game.getTitle()) &&
                Objects.equals(getEsrbRating(), game.getEsrbRating()) &&
                Objects.equals(getDescription(), game.getDescription()) &&
                Objects.equals(getPrice(), game.getPrice()) &&
                Objects.equals(getStudio(), game.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getTitle(), getEsrbRating(), getDescription(),
                getPrice(), getStudio(), getQuantity());
    }
}

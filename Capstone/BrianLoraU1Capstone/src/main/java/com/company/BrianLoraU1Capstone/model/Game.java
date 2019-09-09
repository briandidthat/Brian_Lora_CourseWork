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
        return gameId == game.gameId &&
                quantity == game.quantity &&
                title.equals(game.title) &&
                esrbRating.equals(game.esrbRating) &&
                description.equals(game.description) &&
                price.equals(game.price) &&
                studio.equals(game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, esrbRating, description, price, studio, quantity);
    }
}

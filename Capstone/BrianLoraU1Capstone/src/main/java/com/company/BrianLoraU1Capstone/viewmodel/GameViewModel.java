package com.company.BrianLoraU1Capstone.viewmodel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {
    private int id;
    @NotNull(message="Please supply a value for title")
    private String title;
    @NotNull(message="Please supply a value for rating")
    private String esrbRating;
    @NotNull(message="Please supply a value for description")
    private String description;
    @NotNull(message="Please supply a value for price")
    private BigDecimal price;
    @NotNull(message="Please supply a value for studio")
    private String studio;
    @NotNull(message="Please supply a value for quantity")
    private int quantity;

    // SETTERS
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

    public int getId() {
        return id;
    }

    // GETTERS
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameViewModel that = (GameViewModel) o;
        return id == that.id &&
                quantity == that.quantity &&
                title.equals(that.title) &&
                esrbRating.equals(that.esrbRating) &&
                description.equals(that.description) &&
                price.equals(that.price) &&
                studio.equals(that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrbRating, description, price, studio, quantity);
    }
}

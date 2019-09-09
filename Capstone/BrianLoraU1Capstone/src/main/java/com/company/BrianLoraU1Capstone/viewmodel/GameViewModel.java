package com.company.BrianLoraU1Capstone.viewmodel;


import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {
    private int id;
    @NotEmpty(message="Please supply a value for name")
    private String title;
    @NotEmpty(message="Please supply a value for name")
    private String esrbRating;
    @NotEmpty(message="Please supply a value for name")
    private String description;
    @NotEmpty(message="Please supply a value for name")
    private BigDecimal price;
    @NotEmpty(message="Please supply a value for name")
    private String studio;
    @NotEmpty(message="Please supply a value for name")
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
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getEsrbRating(), that.getEsrbRating()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getStudio(), that.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getEsrbRating(), getDescription(),
                getPrice(), getStudio(), getQuantity());
    }
}

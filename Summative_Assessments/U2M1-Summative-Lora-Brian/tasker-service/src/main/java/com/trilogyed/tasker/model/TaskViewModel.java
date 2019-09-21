package com.trilogyed.tasker.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskViewModel {
    private int id;
    @NotNull(message = "Please enter a value for description.")
    private String description;
    @NotNull(message = "Please enter a value for create date.")
    private LocalDate createDate;
    @NotNull(message = "Please enter a value for due date.")
    private LocalDate dueDate;
    @NotNull(message = "Please enter a value for category.")
    private String category;
    private String advertisement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }
}

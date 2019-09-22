package com.trilogyed.tasker.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {
    private int id;
    @NotNull(message = "Please enter a value for task description.")
    private String taskDescription;
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

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskViewModel that = (TaskViewModel) o;
        return id == that.id &&
                Objects.equals(taskDescription, that.taskDescription) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(category, that.category) &&
                Objects.equals(advertisement, that.advertisement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskDescription, createDate, dueDate, category, advertisement);
    }
}

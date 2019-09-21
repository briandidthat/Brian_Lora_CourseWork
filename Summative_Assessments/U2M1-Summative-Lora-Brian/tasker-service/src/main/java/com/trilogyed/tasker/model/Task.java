package com.trilogyed.tasker.model;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private int id;
    private String taskDescription;
    private LocalDate createDate;
    private LocalDate dueDate;
    private String category;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                taskDescription.equals(task.taskDescription) &&
                createDate.equals(task.createDate) &&
                dueDate.equals(task.dueDate) &&
                category.equals(task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskDescription, createDate, dueDate, category);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskDescription='" + taskDescription + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                '}';
    }
}

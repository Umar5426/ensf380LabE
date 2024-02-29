package edu.ucalgary.oop;

import java.util.Objects;

public class Task {
    private int id;
    private String title;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String title, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id &&
               isCompleted == task.isCompleted &&
               Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }

    // Deep copy method
    public Task copy() {
        Task copiedTask = new Task(this.id, new String(this.title), this.isCompleted);
        return copiedTask;
    }
}

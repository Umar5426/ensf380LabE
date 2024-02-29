package edu.ucalgary.oop;
import java.util.*;

public class Task {
    private String id;
    private String title;
    private boolean isCompleted;

    // Constructor
    public Task(String id, String title, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }
    public Task(String id, String title){
        this.id = id;
        this.title = title;

    }
    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
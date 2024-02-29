package edu.ucalgary.oop;
import java.util;

import java.util.ArrayList;
import java.util.List;

public class ToDoList implements IToDoList {
    private List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(Task task){
        tasks.add(task);
        System.out.println("Task added: " + task.getTitle());
    }

    @Override
    public void completeTask(Task task) {
        task.setCompleted(true);
        System.out.println("Task completed: " + task.getTitle());
    }

    @Override
    public void deleteTask(Task task) {
        tasks.remove(task);
        System.out.println("Task deleted: " + task.getTitle());
    }

    @Override
    public void editTask(Task task) {
        //ADD LOGIC
        System.out.println("Task edited: " + task.getTitle());
    }

    @Override
    public void undo() {
        //ADD LOGIC
        System.out.println("Undo operation performed");
    }

    @Override
    public void listTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println("- " + task.getTitle() + " (Completed: " + task.isCompleted() + ")");
        }
    }

}
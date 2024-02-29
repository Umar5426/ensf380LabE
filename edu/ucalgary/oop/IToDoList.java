package edu.ucalgary.oop;
import java.util;


public interface ToDoList {
    void addTask(Task task);

    void completeTask(Task task);

    void deleteTask(Task task);

    void editTask(Task task);

    void undo();

    void listTasks();
}

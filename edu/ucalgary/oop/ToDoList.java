package edu.ucalgary.oop;
import java.util.*;

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
    public void completeTask(Task task){
        task.setCompleted(true);
        System.out.println("Task completed: " + task.getTitle());
    }

    @Override
    public void deleteTask(Task task){
        tasks.remove(task);
        System.out.println("Task deleted: " + task.getTitle());
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean isCompleted) {
        //finding the task using the id
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) { //Changing/Editing the task itself
                task.setTitle(newTitle);
                task.setCompleted(isCompleted);
                System.out.println("Task edited: " + task.getTitle());
                return;
            }
        }
        // If task with given Id is not found
        System.out.println("Task with ID " + taskId + " not found");
    }


    @Override
    public void undo(){
        //ADD LOGIC
        System.out.println("Undo operation performed");
    }

    @Override
    public void listTasks(){
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println("- " + task.getTitle() + " (Completed: " + task.isCompleted() + ")");
        }
    }
}
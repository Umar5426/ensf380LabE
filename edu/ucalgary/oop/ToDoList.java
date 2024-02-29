package edu.ucalgary.oop;
import java.util.*;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(Task task){
        tasks.add(task);
        saveHistory();
        System.out.println("Task added: " + task.getTitle());
    }

    @Override
    public void completeTask(Task task){
        task.setCompleted(true);
        saveHistory();
        System.out.println("Task completed: " + task.getTitle());
    }

    @Override
    public void deleteTask(Task task){
        tasks.remove(task);
        saveHistory();
        System.out.println("Task deleted: " + task.getTitle());
    }

    @Override
    public void editTask(int taskId, String newTitle, boolean isCompleted) {
        //finding the task using the id
        for (Task task : tasks) {
            if (Integer.valueOf(task.getId()).equals(taskId)) { //Changing/Editing the task itself
                task.setTitle(newTitle);
                task.setCompleted(isCompleted);
                System.out.println("Task edited: " + task.getTitle());
                return;
            }
        }
        // If task with given Id is not found
        saveHistory();
        System.out.println("Task with ID " + taskId + " not found");
    }


    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = new ArrayList<>(history.pop());
            System.out.println("Undo operation performed");
        } else {
            System.out.println("Nothing to undo");
        }
    }

    @Override
    public void listTasks(){
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println("- " + task.getTitle() + " (Completed: " + task.isCompleted() + ")");
        }
    }

    private void saveHistory() {
        List<Task> taskCopy = new ArrayList<>(tasks);
        history.push(taskCopy);
    }
}
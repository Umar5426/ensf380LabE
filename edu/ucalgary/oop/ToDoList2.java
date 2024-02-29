package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        tasks = new ArrayList<>();
        history = new Stack<>();
    }

    @Override
    public void addTask(Task task){
        tasks.add(task);
        saveHistory();
        System.out.println("Task added: " + task.getTitle());
    }

    @Override
    public void completeTask(String id) {
        Task taskToComplete = findTaskById(id);
        if (taskToComplete != null) {
            taskToComplete.setCompleted(true);
            saveHistory();
            System.out.println("Task completed: " + taskToComplete.getTitle());
        } else {
            System.out.println("Task with ID " + id + " not found");
        }
    }

    @Override
    public void deleteTask(String id){
        Task taskToDelete = findTaskById(id);
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            saveHistory();
            System.out.println("Task deleted: " + taskToDelete.getTitle());
        } else {
            System.out.println("Task with ID " + id + " not found");
        }
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean isCompleted) {
        Task taskToEdit = findTaskById(taskId);
        if (taskToEdit != null) {
            taskToEdit.setTitle(newTitle);
            taskToEdit.setCompleted(isCompleted);
            saveHistory();
            System.out.println("Task edited: " + taskToEdit.getTitle());
        } else {
            System.out.println("Task with ID " + taskId + " not found");
        }
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
    public List<Task> listTasks(){
        // Return a copy of the task list to prevent direct modification
        return new ArrayList<>(tasks);
    }

    private void saveHistory() {
        List<Task> taskCopy = new ArrayList<>(tasks);
        history.push(taskCopy);
    }

    private Task findTaskById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}

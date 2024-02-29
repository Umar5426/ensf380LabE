package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList
{
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        tasks = new ArrayList<>();
        history = new Stack<>();
    }

    @Override
    public void addTask(Task task){
        history.push(new ArrayList<>(tasks));
        tasks.add(task);
        System.out.println("Task added: " + task.getTitle());
    }

    @Override
    public void completeTask(String id) {
        history.push(new ArrayList<>(tasks));
        Task taskToComplete = findTaskById(id);
        if (taskToComplete != null) {
            taskToComplete.setCompleted(true);
            System.out.println("Task completed: " + taskToComplete.getTitle());
        } else {
            System.out.println("Task with ID " + id + " not found");
        }
    }

    @Override
    public void deleteTask(String id){
        history.push(new ArrayList<>(tasks));
        Task taskToDelete = findTaskById(id);
        if (taskToDelete != null) {
            tasks.remove(taskToDelete);
            System.out.println("Task deleted: " + taskToDelete.getTitle());
        } else {
            System.out.println("Task with ID " + id + " not found");
        }
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean isCompleted) {
        history.push(new ArrayList<>(tasks));
        Task taskToEdit = findTaskById(taskId);
        if (taskToEdit != null) {
            taskToEdit.setTitle(newTitle);
            taskToEdit.setCompleted(isCompleted);
            System.out.println("Task edited: " + taskToEdit.getTitle());
        } else {
            System.out.println("Task with ID " + taskId + " not found");
        }
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }

    private Task findTaskById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
    @Override
    public List<Task> listTasks(){
        // Return a copy of the task list to prevent direct modification
        return tasks;
    }
}

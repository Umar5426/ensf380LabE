// package edu.ucalgary.oop;
// import java.util.*;

// public class ToDoList implements IToDoList {
//     private List<Task> tasks;
//     private Stack<List<Task>> history;

//     public ToDoList() {
//         tasks = new ArrayList<>();
//     }

//     @Override
//     public void addTask(Task task){
//         tasks.add(task);
//         saveHistory();
//         System.out.println("Task added: " + task.getTitle());
//     }

//     @Override
//     public void completeTask(String id) {
//         // Find the task with the given ID
//         Task taskToComplete = null;
//         for (Task task : tasks) {
//             if (task.getId().equals(id)) {
//                 taskToComplete = task;
//                 break;
//             }
//         }

//         // Check if the task was found
//         if (taskToComplete != null) {
//             // Mark the task as completed
//             taskToComplete.setCompleted(true);
//             saveHistory();
//             System.out.println("Task completed: " + taskToComplete.getTitle());
//         } else {
//             System.out.println("Task with ID " + id + " not found");
//         }
//     }


//     @Override
//     public void deleteTask(String task){
//         tasks.remove(task);
//         saveHistory();
//         System.out.println("Task deleted: " + task.getTitle());
//     }

//     @Override
//     public void editTask(String taskId, String newTitle, boolean isCompleted) {
//         //finding the task using the id
//         for (Task task : tasks) {
//             if (task.getId().equals(taskId)){ //Changing/Editing the task itself
//                 task.setTitle(newTitle);
//                 task.setCompleted(isCompleted);
//                 System.out.println("Task edited: " + task.getTitle());
//                 return;
//             }
//         }
//         // If task with given Id is not found
//         saveHistory();
//         System.out.println("Task with ID " + taskId + " not found");
//     }


//     @Override
//     public void undo() {
//         if (!history.isEmpty()) {
//             tasks = new ArrayList<>(history.pop());
//             System.out.println("Undo operation performed");
//         } else {
//             System.out.println("Nothing to undo");
//         }
//     }

//     @Override
//     public List<Task> listTasks(){
//         return this.tasks; 
//     }

//     private void saveHistory() {
//         List<Task> taskCopy = new ArrayList<>(tasks);
//         history.push(taskCopy);
//     }
// }


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
    // public void deleteTask(String taskId){
    //     for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
    //         Task task = iterator.next();
    //         if (task.getId().equals(taskId)) {
    //             iterator.remove();
    //             System.out.println("Task deleted: " + task.getTitle());
    //             return;
    //         }
    //     }
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

package com.javacourse.lessonpartice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return status + " " + description;
    }
}

public class TodoList {
    private List<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added: " + description);
    }

    public void editTask(int index, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task = new Task(newDescription);
            tasks.set(index, task);
            System.out.println("Task edited: " + newDescription);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.remove(index);
            System.out.println("Task deleted: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsDone();
            System.out.println("Task marked as done: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void printNonCompletedTasks() {
        System.out.println("Non-Completed Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (!task.isDone()) {
                System.out.println(i + ". " + task);
            }
        }
    }

    public void printCompletedTasks() {
        System.out.println("Completed Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.isDone()) {
                System.out.println(i + ". " + task);
            }
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to The To-Do Application!!!");
            System.out.println("Enter an option:");
            System.out.println("1. Add task");
            System.out.println("2. Edit task");
            System.out.println("3. Delete task");
            System.out.println("4. Mark task as done");
            System.out.println("5. Print non-completed tasks");
            System.out.println("6. Print completed tasks");
            System.out.println("7. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task index: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    todoList.editTask(editIndex, newDescription);
                    break;
                case 3:
                    System.out.print("Enter task index: ");
                    int deleteIndex = scanner.nextInt();
                    todoList.deleteTask(deleteIndex);
                    break;
                case 4:
                    System.out.print("Enter task index: ");
                    int markIndex = scanner.nextInt();
                    todoList.markTaskAsDone(markIndex);
                    break;
                case 5:
                    todoList.printNonCompletedTasks();
                    break;
                case 6:
                    todoList.printCompletedTasks();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please Kindly check the Given Option>>>");
                    break;
            }

            System.out.println();
        }

        System.out.println("Exiting TODO list.");

        System.out.println("Thank for using our To-Do Application*** @@Visit Again@@");
    }
}

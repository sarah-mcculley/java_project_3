package com.company;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void  addTask(TaskCollection tasks){
        UserInput input = new UserInput();
        String newTask = input.promptString("Please enter the name of the new task.");
        String newDescription = input.promptString("Please enter the description of the new task");
        int newPriority = input.promptInt("Please enter the priority for the new task");

        Task task = new Task(newTask, newDescription, newPriority);

        tasks.addTask(task);

    }

    public static void removeTask(TaskCollection tasks){
        UserInput input = new UserInput();
        String index = input.promptString("Please enter the index of the task to remove.");

        tasks.remove(Integer.parseInt(index));

    }

    public static void updateTask(TaskCollection tasks){
        UserInput input = new UserInput();
        String index = input.promptString("Enter the index of the task to update.");

        String updatedTask = input.promptString("Enter the new title of the task.");


        String updatedDescription = input.promptString("Enter the new description of the task");

        int newPriority = input.promptInt("Enter the new priority");

        Task item = tasks.get(Integer.parseInt(index));

        item.update(updatedTask, updatedDescription, newPriority );


    }

    public static void listTasks(TaskCollection tasks){

        int i=0;
        tasks.sort();
        for(Task task : tasks)
        {
            System.out.print(i + ". ");
            task.display();
        }


    }

    public static void prioritizeTasks(TaskCollection tasks){
        tasks.sort();
        UserInput input = new UserInput();
        int requestedPriority = input.promptInt("Please enter the number task priority you would like to see");
        int i=0;

        for(Task task : tasks)
        {
            if(requestedPriority == task.getPriority()) {
                System.out.print(i + ". ");
                task.display();
            }
            i++;
        }



    }

    static boolean getUserInput(TaskCollection tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease choose an option. \n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(5) Sort tasks by priority.\n" +
                "(0) Exit.");
        String userInput = scanner.nextLine();
        boolean continueLoop = true;
        switch (userInput) {
            case "0":
                continueLoop = false;
                break;
            case "1":
                addTask(tasks);
                break;
            case "2":
                removeTask(tasks);
                break;
            case "3":
                updateTask(tasks);
                break;
            case "4":
                listTasks(tasks);
                break;
            case "5":
                prioritizeTasks(tasks);
                break;
            default:
                System.out.println("Please choose a valid option.");
        }
        return continueLoop;

    }

    public static void main(String[] args) {
        TaskCollection tasks = new TaskCollection();
        boolean continueLoop = getUserInput(tasks);
        while (continueLoop) {
            continueLoop = getUserInput(tasks);

        }
    }
}

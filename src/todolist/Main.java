package todolist;

import java.util.Scanner;

public class Main {

    static TodoList todoList = new TodoList();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;

        boolean running = true;
        while (running) {
            showMenu();
            menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    todoList.addItem(scanner); // Method to add a new to-do item
                    break;
                case 2:
                    todoList.listAllItems(); // Method to display all items
                    break;

                case 3:
                    todoList.markItemAsCompleted(scanner); // Method to mark an item as completed
                    break;

                case 4:
                    todoList.updateTask(scanner); // Method to modify an item by ID
                    break;
                case 5:
                    todoList.listPendingItems(); // Method to display only pending items
                    break;
                case 6:
                    todoList.listCompletedItems(); // Method to display only completed items
                    break;
                case 7:
                    todoList.deleteTask(scanner);
                    break;
                case 0:
                    running = false; // Exit the loop and end the program
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Select what you want to do:");
        System.out.println("1. Add new todo item");
        System.out.println("2. List items");
        System.out.println("3. Mark as completed");
        System.out.println("4. Update item");
        System.out.println("5. Show items in progress");
        System.out.println("6. Shows completed items");
        System.out.println("7. Delete an item");
        System.out.println("0. Quit program");
        System.out.println("=========================");
    }
}
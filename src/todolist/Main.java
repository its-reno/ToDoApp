package todolist;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

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
                    addNewItem(scanner); // Method to add a new to-do item
                    break;
                case 2:
                    showAllItems(); // Method to display all items
                    break;

                case 3:
                    markItemAsCompleted(scanner); // Method to mark an item as completed
                    break;

                case 4:
                    updateTask(scanner); // Method to remove an item by ID
                    break;
                case 5:
                    showPendingItems(); // Method to display only pending items
                    break;
                case 6:
                    showCompletedItems(); // Method to display only completed items
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


    private static void updateTask(Scanner scanner) {
        System.out.println("Enter the ID of the task you want to modify: ");
        UUID uuid = UUID.fromString(scanner.nextLine());
        System.out.println("Enter the new title: ");
        String newTitle = scanner.nextLine();
        System.out.println("Enter new description: ");
        String newDescription = scanner.nextLine();
        System.out.println("Enter new due date: ");
        String newDueDateString = scanner.nextLine();
        LocalDate newDueDate = null;
        if (!newDueDateString.isEmpty())
            newDueDate = LocalDate.parse(newDueDateString);

        todoList.updateTask(uuid, newTitle, newDescription, newDueDate);
    }

    private static void showMenu() {
        System.out.println("Select what you want to do:");
        System.out.println("1. Add new todo item");
        System.out.println("2. List items");
        System.out.println("3. Mark as completed");
        System.out.println("4. Update item");
        System.out.println("5. Show items in progress");
        System.out.println("6. Shows completed items");
        System.out.println("0. Quit program");
        System.out.println("=========================");
    }

    private static void showCompletedItems() {
        todoList.getCompletedItems();
    }

    private static void showPendingItems() {
        todoList.getPendingItems();
    }

    private static void markItemAsCompleted(Scanner scanner) {
        System.out.println("Enter the ID of the item that's done: ");
        UUID uuid = UUID.fromString(scanner.nextLine());
        todoList.markItemAsCompleted(uuid);
    }

    private static void addNewItem(Scanner scanner) {
        System.out.println("What's the title?");
        String title = scanner.nextLine();
        System.out.println("What's the description");
        String description = scanner.nextLine();
        System.out.println("Enter due date:");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());

        TodoItem item = new TodoItem(title, description, dueDate);

        todoList.addItem(item);
    }

    private static void showAllItems() {
        todoList.getAllItems();
    }

}
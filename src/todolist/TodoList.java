package todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TodoList {
    public List<TodoItem> items = new ArrayList<>();

    //add a new item to the list
    public void addItem(Scanner scanner) {
            System.out.println("What's the title?");
            String title = scanner.nextLine();
            System.out.println("What's the description");
            String description = scanner.nextLine();
            System.out.println("Enter due date:");
            LocalDate dueDate = LocalDate.parse(scanner.nextLine());

            TodoItem item = new TodoItem(title, description, dueDate);

            items.add(item);
        }


    public void getAllItems(){
        for (TodoItem t : items) {
            System.out.println(t.toString());
        }
    }

    public void markItemAsCompleted(Scanner scanner) {
        System.out.println("Enter the ID of the item that's done: ");
        UUID uuid = UUID.fromString(scanner.nextLine());
        for (TodoItem t : items) {
            if (t.getId().equals(uuid)) {
                t.setCompleted();
            }
        }
    }

    public void getPendingItems(){
        for (TodoItem t : items) {
            if (!t.isCompleted()) {
                System.out.println(t);
            }
        }

    }

    public void getCompletedItems(){
        for (TodoItem t : items) {
            if (t.isCompleted()) {
                System.out.println(t);
            }
        }
    }

    public void updateTask(Scanner scanner) {
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


        for (TodoItem t : items) {
            if (t.getId().equals(uuid)) {
                if(!newTitle.isEmpty())
                    t.setTitle(newTitle);
                if(!newDescription.isEmpty())
                    t.setDescription(newDescription);
                if(newDueDate != null)
                    t.setDuedate(newDueDate);

                break;
            }
        }
    }
}
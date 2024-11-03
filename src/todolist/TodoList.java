package todolist;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TodoList {
    public List<TodoItem> items = new ArrayList<>();

    //add a new item to the to-do list
    public void addItem(Scanner scanner) {
        String title = readStringInput(scanner, "Enter title: ");
        String description = readStringInput(scanner, "Enter description: ");
        LocalDate dueDate = readDateInput(scanner, "Enter due date: ");

        TodoItem item = new TodoItem(title, description, dueDate);

        items.add(item);
    }

    //list all items
    public void listAllItems() {
        if(items.isEmpty()){
            System.out.println("The list is empty!\n");
            return;
        }
        for(TodoItem t : items){
            System.out.println(t);
            System.out.println("================================");
        }
    }

    //list all pending items
    public void listPendingItems() {
        boolean found = false;
        for (TodoItem t : items) {
            if (!t.isCompleted()) {
                System.out.println(t);
                System.out.println("=========================="); // Add a separator for clarity
                found = true;
            }
        }
        if (!found) {
            System.out.println("No pending items to display.");
        }

    }

    //list all completed items
    public void listCompletedItems() {
        boolean found = false;
        for (TodoItem t : items) {
            if (t.isCompleted()) {
                System.out.println(t);
                System.out.println("=========================="); // Add a separator for clarity
                found = true;
            }
        }
        if (!found) {
            System.out.println("No completed items to display.");
        }
    }

    //mark an item as completed
    public void markItemAsCompleted(Scanner scanner) {
        if(items.isEmpty()){
            System.out.println("The list is empty, there's nothing to mark as completed!");
            return;
        }

        UUID uuid = readUUIDInput(scanner, "Enter the ID of the item that's done: ");
        boolean found = false;
        for(TodoItem t : items){
            if(t.getId().equals(uuid)){
                t.setCompleted();
                found = true;
                System.out.println("Item marked es completed!");
            }
        }
        if (!found)
            System.out.println("The ID you entered doesn't exist");
    }


    //modify a task
    public void updateTask(Scanner scanner) {
        UUID uuid = readUUIDInput(scanner, "Enter the ID of the task you want to modify: ");

        //check if the UUID exists
        TodoItem itemToUpdate = null;
        for(TodoItem t : items){
            if(t.getId().equals(uuid)){
                itemToUpdate = t;
                break;
            }
        }

        if(itemToUpdate == null){
            System.out.println("No item found with that ID");
            return;
        }

        //show the current values of the item
        System.out.println("Current values:");
        System.out.println("Title: " + itemToUpdate.getTitle());
        System.out.println("Description: " + itemToUpdate.getDescription());
        System.out.println("Due date: " + itemToUpdate.getDuedate());

        //update the values. If input is null leave the old value.
        for(TodoItem t : items){
            if(t.getId().equals(uuid)){
                String newTitle = readStringInput(scanner, "Enter new title: ");
                String newDescription = readStringInput(scanner, "Enter new description: ");
                LocalDate newDueDate = readDateInput(scanner, "Enter new due date: ");
                if(!newTitle.isEmpty())
                    t.setTitle(newTitle);
                if(!newDescription.isEmpty())
                    t.setDescription(newDescription);
                if(newDueDate != null)
                    t.setDuedate(newDueDate);

                System.out.println("Task updated successfully!");
                break;
            }
        }
    }

    public void deleteTask(Scanner scanner) {
        if(items.isEmpty()){
            System.out.println("There's nothing to delete, you haven't added any items yet.");
            return;
        }

        UUID uuid = readUUIDInput(scanner, "Enter the ID of the item you want to delete: ");

        boolean found = false;
        for(TodoItem t : items){
            if(t.getId().equals(uuid)){
                found = true;
                System.out.println("Item found: ");
                System.out.println("Title: " + t.getTitle());
                System.out.println("Description: " + t.getDescription());
                System.out.println("Due date: " + t.getDuedate());
                String confirmDelete = readStringInput(scanner, "Are you sure you want to delete it? Y/N");
                if(confirmDelete.toLowerCase().trim().equals("y") ||confirmDelete.toLowerCase().trim().equals("yes")) {
                    items.remove(t);
                    System.out.println("Item deleted successfully!");
                    return;
                } else {
                    System.out.println("Item deletion aborted!");
                }
            }
        }
        if(!found){
            System.out.println("The ID you've entered doesn't exist!");
        }
    }


    //read user String input
    private String readStringInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    //read user UUID inpit
    private UUID readUUIDInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        try {
            return UUID.fromString(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid UUID format.");
            return null;
        }
    }

    //read user Date input
    private LocalDate readDateInput(Scanner scanner, String prompt) {
                String input = readStringInput(scanner, prompt);

        if(input.isEmpty()){
            return null;
        }

        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use the format YYYY-MM-DD.");
            return null;
        }
    }
}
package todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TodoList {
    public List<TodoItem> items = new ArrayList<>();

    //add a new item to the to-do list
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

    //list all items
    public void getAllItems() {
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
    public void getPendingItems() {
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
    public void getCompletedItems() {
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

        System.out.println("Enter the ID of the item that's done: ");
        UUID uuid;
        try {
            uuid = UUID.fromString(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ID format.");
            return;
        }

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
        System.out.println("Enter the ID of the task you want to modify: ");
        UUID uuid;
        try {
            uuid = UUID.fromString(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid ID format");
            return;
        }

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
                System.out.println("Enter the new title: ");
                String newTitle = scanner.nextLine();
                System.out.println("Enter new description: ");
                String newDescription = scanner.nextLine();
                System.out.println("Enter new due date: ");
                String newDueDateString = scanner.nextLine();
                LocalDate newDueDate = null;
                if(!newDueDateString.isEmpty())
                    newDueDate = LocalDate.parse(newDueDateString);
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
        System.out.println("Enter the ID of the item you want to delete: ");
        UUID uuid;
        try {
            uuid = UUID.fromString(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid format!");
            return;
        }

        boolean found = false;
        for(TodoItem t : items){
            if(t.getId().equals(uuid)){
                found = true;
                System.out.println("Item found: ");
                System.out.println("Title: " + t.getTitle());
                System.out.println("Description: " + t.getDescription());
                System.out.println("Due date: " + t.getDuedate());
                System.out.println("Are you sure you want to delete it? Y/N");
                String confirmDelete = scanner.nextLine();
                if(confirmDelete.toLowerCase().equals("y") ||confirmDelete.toLowerCase().equals("yes")) {
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
}
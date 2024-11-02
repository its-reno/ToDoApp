package todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoList {
    public List<TodoItem> items = new ArrayList<>();

    //add a new item to the list
    public void addItem(TodoItem item) {
        items.add(item);
    }

    public void getAllItems(){
        for (TodoItem t : items) {
            System.out.println(t.toString());
        }
    }

    public void markItemAsCompleted(UUID uuid) {
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

    public void updateTask() {
        setTitle(title);
        setDescription(description);
        setDeadline(dueDate);
    }
}
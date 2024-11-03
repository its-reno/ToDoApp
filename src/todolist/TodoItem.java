package todolist;

import java.time.LocalDate;
import java.util.UUID;

public class TodoItem {

    private UUID id;
    private String title;
    private String description;
    private boolean isCompleted;
    private LocalDate timestamp;
    private LocalDate duedate;

    public TodoItem(String name, String description, LocalDate duedate) {
        this.id = UUID.randomUUID();
        this.title = name;
        this.description = description;
        this.isCompleted = false;
        this.timestamp = LocalDate.now();
        this.duedate = duedate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        this.isCompleted = true;
    }


    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    @Override
    public String toString() {
        String status = isCompleted ? "Completed" : "Pending";
        return String.format("ID: %s\nTitle: %s\nDescription: %s\nDue Date: %s\nStatus: %s\n",
                id.toString(), title, description, duedate.toString(), status);
    }
}

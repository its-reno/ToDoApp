package todolist;

import java.time.LocalDate;
import java.util.UUID;

public class TodoItem {

    private UUID id;
    private String title;
    private String description;
    private boolean isCompleted;
    private LocalDate timestamp;
    private LocalDate deadline;

    public TodoItem(String name, String description, LocalDate deadline) {
        this.id = UUID.randomUUID();
        this.title = name;
        this.description = description;
        this.isCompleted = false;
        this.timestamp = LocalDate.now();
        this.deadline = deadline;
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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "TodoRecord{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", isCompleted='" + isCompleted + '\'' +
                ", timestamp=" + timestamp +
                ", deadline=" + deadline +
                '}';
    }


}

## To-Do List Console Application

This is a simple **console-based To-Do List application** implemented in Java. It allows users to manage their tasks by adding, updating, completing, and deleting tasks. The application is designed for practice purposes and demonstrates fundamental Java programming skills, including object-oriented principles, user input handling, and task management.

## Features

- **Add a Task:** Create a new task with a title, description, and due date.
- **List All Tasks:** Display all tasks in the to-do list.
- **List Pending Tasks:** Show only tasks that are not yet marked as completed.
- **List Completed Tasks:** Display tasks that have been marked as completed.
- **Mark a Task as Completed:** Update the status of a task to indicate it has been completed.
- **Update a Task:** Modify the title, description, or due date of an existing task.
- **Delete a Task:** Remove a task from the list after confirmation.

## How It Works

1. The user interacts with the application through the console by selecting options from a menu.
2. The application uses the `TodoList` class to:
    - Store tasks in an in-memory list (`items`).
    - Perform operations such as adding, listing, updating, completing, or deleting tasks based on user input.
3. Input validation is implemented for dates (must follow `YYYY-MM-DD` format) and UUIDs (used as unique identifiers for tasks).
   

## Data Structure

Tasks are stored in an in-memory list (`items`) as instances of the `TodoItem` class. Each task has:

- A unique identifier (UUID)
- Title
- Description
- Due date
- Completion status


## Limitations

- No persistent data storage; all tasks are lost when the program exits.
- Limited error handling for invalid inputs (e.g., incorrect UUIDs or empty fields).
- Not designed for production use.

## How to Run

1. Clone or download this repository.
2. Compile and run the Java application in your preferred IDE or via the command line:    
    ```
   javac Main.java
   java Main
   ```
    
3. Follow the prompts in the console to interact with the application.

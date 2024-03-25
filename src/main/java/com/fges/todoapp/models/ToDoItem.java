package com.fges.todoapp.models;

public class ToDoItem {

    // Model Attributes
    private String toDoItemName;
    private boolean toDoStatus;

    // Main Constructor
    public ToDoItem(String toDoItemName, boolean toDoStatus) {
        this.toDoItemName = toDoItemName;
        this.toDoStatus = toDoStatus;
    }

    // Getters and Setters
    public String getToDoItemName() {
        return toDoItemName;
    }

    public void setToDoItemName(String toDoItemName) {
        this.toDoItemName = toDoItemName;
    }

    public boolean isToDoStatus() {
        return toDoStatus;
    }

    public void setToDoStatus(boolean toDoStatus) {
        this.toDoStatus = toDoStatus;
    }

    public String toString() {
        if(toDoStatus){
            return "Done: " + toDoItemName;
        }
        else{
            return toDoItemName;
        }
    }
}
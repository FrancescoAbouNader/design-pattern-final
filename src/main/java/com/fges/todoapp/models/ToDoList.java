package com.fges.todoapp.models;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<ToDoItem> toDoItems;

    // Main Constructor
    public ToDoList(ArrayList<ToDoItem> toDoItems){
        this.toDoItems = toDoItems;
    }

    // Getters and Setters
    public ArrayList<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(ArrayList<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }
}
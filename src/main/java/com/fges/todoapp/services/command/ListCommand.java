package com.fges.todoapp.services.command;

import com.fges.todoapp.models.ToDoItem;
import com.fges.todoapp.models.ToDoList;
import com.fges.todoapp.services.datasource.ToDoService;

import java.util.ArrayList;

public class ListCommand extends CommandService{
    private ToDoService toDoService;

    public ListCommand(ToDoService service) {
        this.toDoService = service;
    }

    @Override
    public void execute() {
        ToDoList todos = toDoService.getTodos();
    }
}
